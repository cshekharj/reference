package com.chandra.algo;

public class FibonacciByIteration {

	public static void main(String[] args) {
		
		//fibonacci(0);
		//fibonacci(1);
		//fibonacci(2);
		fibonacci(3);
		fibonacci(5);
		//fibonacci(10);
	}
	/* * Printing Fibonacci series of a given number using for loop */ 
	public static void fibonacci(int number) { 
		if(number < 0)
			throw new IllegalArgumentException("Input needs to be greater than or equal to 0");
		
		int fib0=0; int fib1 = 1; 
		int prev=0; int next=1; int result=0;
		
		System.out.printf("%nFibonacci series for %d is- : ", number); 
		System.out.printf("%s ", 0);
		
		for (int i = 0; i< number; i++) { 
			result = prev+next;
			prev=next;
			next=result;
			System.out.printf("%s ", result); 
			
			} 
		}
}
