import ServiceModule.*;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import java.util.Scanner;

public class ServiceClient {
	public static void main(String args[]) {
		try {
			ORB orb = ORB.init(args, null);
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

			String name = "Service";
			ServiceInterface service = ServiceInterfaceHelper.narrow(ncRef.resolve_str(name));
		
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter String 1: ");
			String s1 = scanner.nextLine();
			System.out.print("Enter String 2: ");
			String s2 = scanner.nextLine();

			String result = service.concat(s1, s2);
			System.out.println("At Client: concat(" + s1 + "," + s2 + ") = " + result);

			scanner.close();
			orb.shutdown(true);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}
}
