import java.util.Scanner;

public class Bully {
	int coordinator;
	int max_processes;
	boolean processes[];

	public Bully(int max) {
		max_processes = max;
		processes = new boolean[max_processes];
		coordinator = max;

		System.out.print("Creating Prcesses...");
		for (int i = 0; i < max_processes; i++) {
			processes[i] = true;
			System.out.println("Process: " + (i + 1) + " Created");
		}
		System.out.println("Process: " + coordinator + " is the coordinator");
	}

	void displayProcesses() {
		for (int i = 0; i < max_processes; i++) {
			System.out.println("Process: " + (i + 1) + " is " + (processes[i] ? "up" : "down"));
		}
		System.out.println("Process: " + coordinator + " is the coordinator");
	}

	void upProcess(int process_id) {
		if (processes[process_id - 1]) {
			System.out.println("Process: " + process_id + " is already up");
			return;
		}
		processes[process_id - 1] = true;
		System.out.println("Process: " + process_id + " is now up");
	}

	void downProcess(int process_id) {
		if (!processes[process_id - 1]) {
			System.out.println("Process: " + process_id + " is already down");
			return;
		}
		processes[process_id - 1] = false;
		System.out.println("Process: " + process_id + " is now down");
	}

	void runElection(int process_id) {
		coordinator = process_id;
		boolean keepGoing = true;

		for (int i = process_id; i < max_processes && keepGoing; i++) {
			System.out.println("Election message sent form process: " + process_id + " to process: " + (i + 1));
			if (processes[i]) {
				keepGoing = false;
				runElection(i + 1);
			}
		}
	}

	public static void main(String args[]) {
		Bully bully = null;
		int max_processes = 0, process_id = 0;
		int choice = 0;
		Scanner scanner = new Scanner(System.in);

		while(true) {
			System.out.println("Bully Algorithm");
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
					System.out.println("Enter the number of processes: ");
					max_processes = scanner.nextInt();
					bully = new Bully(max_processes);
					break;
				case 2:
					bully.displayProcesses();
					break;
				case 3:
					System.out.print("Enter the process number to up: ");
					process_id = scanner.nextInt();
					bully.upProcess(process_id);
					break;
				case 4:
					System.out.print("Enter the process number to down: ");
					process_id = scanner.nextInt();
					bully.downProcess(process_id);
					break;
				case 5:
					System.out.print("Enter the process number which will perform election: ");
					process_id = scanner.nextInt();
					bully.runElection(process_id);
					bully.displayProcesses();
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





















					

































			


