package kr.co.arajeju.aracoupon3.util;

import java.util.Random;

public class GenerateAraKey {

	private static final int SIZE_ARA_KEY = 4;
	private static final Random rand;
	
	static {
		rand = new Random();
		rand.setSeed(System.currentTimeMillis());
	}
	
	public static String getAraKey() throws Exception {
		return getAraKey(SIZE_ARA_KEY);
	}
	
	private static String getAraKey(int size) throws Exception {
		String str = "";
		do {
			str = String.valueOf(Math.abs(rand.nextLong()));
		} while (str.length() < size);

		return str.substring(0, size);
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(">>>>> Hello world!!!");
		
		for (int i=0; i < 20; i++) {
			System.out.println(">>>>> " + getAraKey());
		}
	}
}
