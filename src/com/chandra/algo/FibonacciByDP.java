package com.chandra.algo;

import java.util.Scanner;

public class FibonacciByDP {

	private static final Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		int n=scanner.nextInt();
		fibonacciDP(n);
	}
	
	private static void fibonacciDP(int n) {
		int[] fib=new int [n+2];
		
		fib[0]=0;
		fib[1]=1;
		for(int i=2;i<=n;i++){
			fib[i]=fib[i-1]+fib[i-2];
		}
		System.out.println( fib[n]);
	}

}
