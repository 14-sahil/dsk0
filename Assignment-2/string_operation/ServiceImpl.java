import ServiceModule.*;

public class ServiceImpl extends ServiceInterfacePOA {
	public String concat(String s1, String s2) {
		String result = s1 + s2;
		System.out.println("At Server: concat(" + s1 + "," + s2 + ") = " + result);
		return result;
	}
}
