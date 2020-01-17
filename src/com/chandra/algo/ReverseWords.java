package com.chandra.algo;

import java.util.Scanner;

/*
 * Given a sentence reverse the words in it "in place" without using extra memory
 * No tokenization and reassembly*/
public class ReverseWords {

	public static final Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		String input=scanner.nextLine();
		System.out.println(input.length());
		char[] strArray=input.toCharArray();
		char c;
		for(int i=0,j=strArray.length-1;j>i;i++,j--){
			c = strArray[i];
			strArray[i]=strArray[j];
			strArray[j]=c;
		}
		input=new String(strArray);
		strArray=input.toCharArray();
		
		for(int i=0;i<strArray.length;i++){
			//if(strArray[i] == " ")
		}
		System.out.println(input);
	}

}
