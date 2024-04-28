import java.util.Scanner;

public class TokenRing {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter Number Of Node: ");
		int numberOfNode = scanner.nextInt();

		System.out.print("Ring Formed: ");
		for (int i = 0; i < numberOfNode; i++) {
			System.out.print(i + "-");
		}
		System.out.println("0");

		int token = 0;
		while (true) {
			System.out.print("Enter Sender: ");
			int sender = scanner.nextInt();
			System.out.print("Enter Receiver: ");
			int receiver = scanner.nextInt();
			System.out.print("Enter Date To Send: ");
			int data = scanner.nextInt();

			System.out.print("Token Passing: ");
			for (int i = token; i < sender; i++) {
				System.out.print(i + "->");
			}
			
			if(receiver == sender + 1) {
				System.out.println("Sender: " + sender + " Sending The Data: " + data);
				System.out.println("Receiver: " + receiver + " Received The Data: " + data);
			} else {
				System.out.println(sender);
				System.out.println("Sender: " + sender + " Sending The Data: " + data);

				for (int i = sender; i != receiver; i = (i+1) % numberOfNode) {
					System.out.println("Data: " + data + " Forwared By: " + i);
				}

				System.out.println("Receiver: " + receiver + " Received The Data: " + data);
			}

			token = sender;
		}
	}
}
			
