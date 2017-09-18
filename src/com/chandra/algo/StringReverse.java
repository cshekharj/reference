package com.chandra.algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class StringReverse {
	
	static String str ="";
	
	public static void main (String args[]){
		System.out.print("Enter the input string :-");
		
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));){
				str = reader.readLine();
				System.out.println("Original String-"+str);
				char[] strArray = str.toCharArray();
				
				System.out.println("Printing String in reverse order");
				//just print in reverse order
				for(int i=str.length()-1;i>=0;--i){
					System.out.print(str.charAt(i));
				}
				
				System.out.println();
				//actually reverse the chars in array
				for(int j=str.length()-1,i=0;j>=0;j--,i++){
						strArray[i]=str.charAt(j);
				}
				String newStr = new String(strArray);
				System.out.println("Actual Reversed String-"+newStr);
				
				System.out.println();
				StringBuffer buff = new StringBuffer();
				System.out.println("Reversing with Buffer -"+buff.append(str).reverse());
				
				
		} catch (IOException e) {
			e.printStackTrace();
		}
       
	}

}
