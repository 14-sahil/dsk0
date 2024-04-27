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
			System.out.println("Enter num 1: ");
			float num1 = scanner.nextFloat();
			System.out.println("Enter num 2: ");
			float num2 = scanner.nextFloat();

			float resultAdd = service.add(num1, num2);
			float resultSub = service.sub(num1, num2);
			float resultMulti = service.multi(num1, num2);
			float resultDiv = service.div(num1, num2);

			System.out.println("At Client: add(" + num1 + "," + num2 + ") = " + resultAdd);
			System.out.println("At Client: sub(" + num1 + "," + num2 + ") = " + resultSub);
			System.out.println("At Client: multi(" + num1 + "," + num2 + ") = " + resultMulti);
			System.out.println("At Client: div(" + num1 + "," + num2 + ") = " + resultDiv);

			scanner.close();
			orb.shutdown(true);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}
}
