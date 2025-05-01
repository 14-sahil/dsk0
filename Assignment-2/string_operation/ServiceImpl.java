import ServiceModule.*;

public class ServiceImpl extends ServiceInterfacePOA {
	public String concat(String s1, String s2) {
		String result = s1 + s2;
		System.out.println("At Server: concat(" + s1 + "," + s2 + ") = " + result);
		return result;
	}

	public boolean isPalindrome(String str) {
		String reversed = new StringBuilder(str).reverse().toString();
		boolean result = str.equalsIgnoreCase(reversed);
		System.out.println("At Server: isPalindrome(" + str + ") = " + (result ? "Yes" : "No"));
		return result;
	}
}
