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
		
			System.out.println("Enter a number: ");
			double num = scanner.nextDouble();

			boolean result = service.isEven(num);
			System.out.println("At Client: isEven(" + num + ") = " + (result ? "Yes" : "No"));

			double sq = service.square(num);
			System.out.println("At Client: square(" + num + ") = " + sq);

			double sqrt = service.squareRoot(num);
			System.out.println("At Client: squareRoot(" + num + ") = " + sqrt);


			scanner.close();
			orb.shutdown(true);
		} catch (Exception e) {
			System.out.println("Excepton: " + e);
		}
	}
}

