package HelloJava;

public class Test {

	public static void main(String[] args) {
		String a="qwe;fff;qwr;2;f;asf";
		String[] ds=a.split("[;]");
		System.out.println(ds.length);
	}
}