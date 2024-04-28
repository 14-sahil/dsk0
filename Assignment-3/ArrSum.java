import mpi.*;

public class ArrSum {
	public static void main(String args[]) throws Exception {
		MPI.Init(args);

		int rank = MPI.COMM_WORLD.Rank();
		int size = MPI.COMM_WORLD.Size();

		int unitsize = 5;
		int root = 0;

		int total_elements = unitsize * size;
		int send_buffer[] = new int[total_elements];
		int recieve_buffer[] = new int[unitsize];
		int gather_buffer[] = new int[size];

		if (rank == root) {
			System.out.println("Total Elements: " + total_elements);
			for (int i = 0; i < total_elements; i++) {
				send_buffer[i] = i + 1;
			}
		}

		MPI.COMM_WORLD.Scatter(
			send_buffer, 0, unitsize, MPI.INT,
			recieve_buffer, 0, unitsize, MPI.INT,
			root
		);

		int local_sum = 0;
		for (int i = 0; i < unitsize; i++) {
			local_sum += recieve_buffer[i];
		}

		System.out.println("Intermediate Sum At Process: " + rank + " is " + local_sum);

		int local_sum_buffer[] = {local_sum}; 
		MPI.COMM_WORLD.Gather(
			local_sum_buffer, 0, 1, MPI.INT,
			gather_buffer, 0, 1, MPI.INT,
			root
		);

		if (rank == root) {
			int total_sum = 0;
			for (int i = 0; i < size; i++) {
				total_sum += gather_buffer[i];
			}
			System.out.println("Final Sum: " + total_sum);
		}
		
		MPI.Finalize();
	}
}
