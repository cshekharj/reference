package com.chandra.algo;

public class SwapNumber {

	private static int a = 7;
	private static int b = 4;
	
	public static void main(String[] args) {
		//swap numbers
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println("a ="+a);
		System.out.println("b ="+b);
	}

}
