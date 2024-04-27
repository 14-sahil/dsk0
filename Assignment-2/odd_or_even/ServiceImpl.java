import ServiceModule.*;

public class ServiceImpl extends ServiceInterfacePOA {
	public boolean isEven(double num) {
		boolean result = num % 2 == 0;
		System.out.println("At Server: isEven(" + num + ") = " + (result ? "Yes" : "No"));
		return result;
	}
}
