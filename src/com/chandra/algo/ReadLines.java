package com.chandra.algo;

import java.util.Scanner;

public class ReadLines {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "";
		Scanner sc = new Scanner(System.in); 

	       while(sc.hasNextLine()){
	    	    input+=sc.nextLine();
	       }
	       //sc.close();
	       System.out.println("input -"+input);
	       
	}

}
