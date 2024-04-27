import ServiceModule.*;

public class ServiceImpl extends ServiceInterfacePOA {
	public float add(float num1, float num2) {
		float result = num1 + num2;
		System.out.println("At Server: add(" + num1 + "," + num2 + ") = " + result);
		return result;
	}
	public float sub(float num1, float num2) {
		float result = num1 - num2;
		System.out.println("At Server: sub(" + num1 + "," + num2 + ") = " + result);
		return result;
	}
	public float multi(float num1, float num2) {
		float result = num1 * num2;
		System.out.println("At Server: multi(" + num1 + "," + num2 + ") = " + result);
		return result;
	}
	public float div(float num1, float num2) {
		float result = num1 / num2;
		System.out.println("At Server: div(" + num1 + "," + num2 + ") = " + result);
		return result;
	}
}
