package com.chandra.algo;

public class CharSequenceCount {

	/*
	 *  input - aaabbcccaaddefff
	 *  output - a3b2c3a2d2ef3
	 * */
	public static void main(String[] args) {
		
		String input = "caaabbcccaaddeffffffffffffee";
		int count=0;
		for(int i=0;i<input.length();i++){
			char c = input.charAt(i);
			// handle last character case
			if((i+1)==input.length()){
				System.out.print(c);
				System.out.print(count+1);
				break;
			}
			if(input.charAt(i) == input.charAt(i+1)){
				count++;
			}
			else{
				System.out.print(c);
				System.out.print(count+1);
				count=0;
			}
		}
	}

}
