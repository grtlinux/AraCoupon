package kr.co.arajeju.aracoupon2.util;

public class RegExTest {

	public static void main(String[] args) throws Exception {
		String str = "${HOME}/FILE";
		str = str.replaceAll("\\$\\{HOME\\}", "kang");
		System.out.println(">>>>> " + str);
	}
}
