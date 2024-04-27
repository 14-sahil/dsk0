import ServiceModule.*;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;

public class ServiceServer {
	public static void main(String args[]) {
		try {
			ORB orb = ORB.init(args, null);
			POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			rootpoa.the_POAManager().activate();

			ServiceImpl serviceImpl = new ServiceImpl();

			org.omg.CORBA.Object ref = rootpoa.servant_to_reference(serviceImpl);
			ServiceInterface href = ServiceInterfaceHelper.narrow(ref);

			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

			String name = "Service";
			NameComponent path[] = ncRef.to_name(name);
			ncRef.rebind(path, href);

			System.out.println("Server Started...");

			orb.run();
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}
}
