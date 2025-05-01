import ServiceModule.*;

public class ServiceImpl extends ServiceInterfacePOA {
	public boolean isEven(double num) {
		boolean result = num % 2 == 0;
		System.out.println("At Server: isEven(" + num + ") = " + (result ? "Yes" : "No"));
		return result;
	}

	public double square(double num) {
		double result = num * num;
		System.out.println("At Server: square(" + num + ") = " + result);
		return result;
	}

	public double squareRoot(double num) {
		double result = Math.sqrt(num);
		System.out.println("At Server: squareRoot(" + num + ") = " + result);
		return result;
	}
}
