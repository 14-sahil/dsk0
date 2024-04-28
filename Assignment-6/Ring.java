import java.util.*;

public class Ring {
	int coordinator;
	int max_processes;
	boolean processes[];
	ArrayList<Integer> pid;

	public Ring(int max) {
		max_processes = max;
		processes = new boolean[max_processes];
		coordinator = max_processes;
		pid = new ArrayList<Integer>();

		System.out.println("Creating Prcesses...");
		for (int i = 0; i < max_processes; i++) {
			processes[i] = true;
			System.out.println("Process: " + (i + 1) + " Created");
		}
		System.out.println("Process: " + coordinator + " is the coordinator\n");
	}

	void displayProcesses() {
		for (int i = 0; i < max_processes; i++) {
			System.out.println("Process: " + (i + 1) + " is " + (processes[i] ? "up" : "down"));
		}
		System.out.println("Process: " + coordinator + " is the coordinator\n");
	}

	void upProcess(int process_id) {
		if (processes[process_id - 1]) {
			System.out.println("Process: " + process_id + " is already up");
			return;
		}
		processes[process_id - 1] = true;
		System.out.println("Process: " + process_id + " is now up\n");
	}

	void downProcess(int process_id) {
		if (!processes[process_id - 1]) {
			System.out.println("Process: " + process_id + " is already down");
			return;
		}
		processes[process_id - 1] = false;
		System.out.println("Process: " + process_id + " is now down\n");
	}

	void displayArrayList(ArrayList<Integer> pid) {
		System.out.print("[");
		for (Integer x: pid) {
			System.out.print(x);
		}
		System.out.print("]");
	}

	void runElection(int process_id) {
		if (processes[process_id - 1]) {
			pid.add(process_id);
			int temp = process_id;

			System.out.print("\nProcess: " + process_id + " sending the following list: ");
			displayArrayList(pid);

			while(temp != process_id - 1) {
				if (processes[temp]) {
					pid.add(temp + 1);
					System.out.print("\nProcess: " + ( temp + 1 ) + " sending the following list: ");
					displayArrayList(pid);
				}
				temp = (temp + 1) % max_processes;
			}
			coordinator = Collections.max(pid);
			System.out.println("\nProcess: " + process_id + " has declared Process: " + coordinator + " as the coordinator\n");
			pid.clear();
		}

	}

	public static void main(String args[]) {
		Ring ring= null;
		int max_processes = 0, process_id = 0;
		int choice = 0;
		Scanner scanner = new Scanner(System.in);

		while(true) {
			System.out.println("\nRing Algorithm");
			System.out.println("1. Create Processes");
			System.out.println("2. Display Proceses");
			System.out.println("3. Up a process");
			System.out.println("4. Down a process");
			System.out.println("5. Run election algorithm");
			System.out.println("6. Exit Program");
			System.out.print("Enter Your Choice: ");
			choice = scanner.nextInt();

			switch(choice) {
				case 1:
					System.out.print("Enter the number of processes: ");
					max_processes = scanner.nextInt();
					ring = new Ring(max_processes);
					break;
				case 2:
					ring.displayProcesses();
					break;
				case 3:
					System.out.print("Enter the process number to up: ");
					process_id = scanner.nextInt();
					ring.upProcess(process_id);
					break;
				case 4:
					System.out.print("Enter the process number to down: ");
					process_id = scanner.nextInt();
					ring.downProcess(process_id);
					break;
				case 5:
					System.out.print("Enter the process number which will perform election: ");
					process_id = scanner.nextInt();
					ring.runElection(process_id);
					ring.displayProcesses();
					break;
				case 6: 
					System.exit(0);
					break;
				default:
					System.out.println("Error in choice enter valid choice");
					break;
			}
		}
	}
}





















					

































			


