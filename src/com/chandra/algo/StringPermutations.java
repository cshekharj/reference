package com.chandra.algo;

import java.util.Scanner;

public class StringPermutations {

	private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		String input=scanner.nextLine();
		String prefix="";
		permutate(prefix,input);
	}

	private static void permutate(String prefix, String input) {
		int n=input.length();
		System.out.println("Prefix- "+prefix);
		System.out.println("input- "+input);
		
		if (n == 0) {
			System.out.println("Combo - "+prefix);
			System.out.println("---------xxxxx------------");
		}else
			for(int i=0;i<n;i++){
				System.out.println("prefix+input.charAt("+i+") - "+prefix+input.charAt(i));
				System.out.println("input.substring(0,"+i+") - "+input.substring(0,i));
				System.out.println("input.substring("+i+"+1, "+n+") - "+input.substring(i+1, n));
				System.out.println("---------xxxxx------------");
				permutate(prefix+input.charAt(i),input.substring(0,i)+input.substring(i+1, n));
			}
		
	}
}
