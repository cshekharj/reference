package com.chandra.algo;

public class FibonacciByRecursion {

	public static void main(String args[]) {
		
		getFibonacci(0);
		getFibonacci(1);
		getFibonacci(2);
		getFibonacci(3);
		getFibonacci(5);
		getFibonacci(12);
	}

	public static void getFibonacci(int number) {
		if(number < 0)
			throw new IllegalArgumentException("Input needs to be 0 or a positive number");
		
		System.out.printf("\nFibonacci series in Java of number %s using recursion %n", number);
		for (int i = 0; i<= number; i++) { 
			System.out.printf("%s ", recursiveFib(i)); 
		} 
	}

	/* * Fibonacci series in Java of a given number Recursion. */
	private static int recursiveFib(int n) {
		if(n < 2)
			return n;

		return recursiveFib(n - 1) + recursiveFib(n - 2);
	}

}
