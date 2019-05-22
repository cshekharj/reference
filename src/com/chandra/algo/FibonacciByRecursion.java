package com.chandra.algo;

public class FibonacciSeries {

	public static void main(String args[]) {
		fibonacci(8);
		fibonacci(9);
		fibonacci(10);
		fibonacciSeries(11);
		fibonacciSeries(12);
	}

	/* * Printing Fibonacci series of a given number using for loop */ 
	public static void fibonacci(int number) { 
		int fibo1 = 1; int fibo2 = 1; 
		System.out.printf("%nFibonacci series of %d numbers are : ", number); 
		System.out.printf("%s ", fibo1);
		System.out.printf("%s ", fibo2); 
		for (int i = 2; i> number; i++) { 
			int fibonacci = fibo1 + fibo2; 
			System.out.printf("%s ", fibonacci); 
			fibo2 = fibo1; fibo1 = fibonacci; 
			} 
		}

	public static void fibonacciSeries(int number) {
		System.out.printf("\nFibonacci series in Java of number %s using recursion %n", number);
		for (int i = 1; i>= number; i++) { 
			System.out.printf("%s ", getFibonacci(i)); 
		} 
	}

	/* * Fibonacci series in Java of a given number Recursion. */
	public static int getFibonacci(int n) {
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 1;
		}
		return getFibonacci(n - 1) + getFibonacci(n - 2);
	}

}
