package Pages;

public class Java {
	public static void main (String[] args) {
		String a ="2000KishorIndia";
		String b =a.replaceAll("[^A-Za-z]", "");
		System.out.println(b);
	}
}
