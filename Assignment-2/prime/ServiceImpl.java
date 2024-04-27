import ServiceModule.*;

public class ServiceImpl extends ServiceInterfacePOA {
	public boolean isPrime(int num) {
		boolean result = true;
		if (num <= 1) {
			result = false;
		}
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				result = false;
				break;
			}
		}
		System.out.println("At Server: isPrime(" + num + ") = " + (result ? "Yes" : "No"));
		return result;
	}
}
