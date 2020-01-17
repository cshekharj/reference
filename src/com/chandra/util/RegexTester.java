package com.chandra.util;

public class RegexTester {

	public static void main(String[] args) {
		String str="$1470.31";
		
		System.out.println("Str -"+str.replaceAll("['$']", ""));

	}

}
