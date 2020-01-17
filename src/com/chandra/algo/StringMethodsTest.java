package com.chandra.algo;

public class StringMethodsTest {

	public static void main(String args[]){
	       String str1 = new String("This is a test String");
	       String str2 = new String("Test ABC");
	       boolean var1 = str1.endsWith(" is a test String");
	       boolean var2 = str1.endsWith("ABC");
	       boolean var3 = str2.endsWith("String");
	       boolean var4 = str2.endsWith("ABC");
	       System.out.println("str1 ends with String: "+ var1);
	       System.out.println("str1 ends with ABC: "+ var2);
	       System.out.println("str2 ends with String: "+ var3);
	       System.out.println("str2 ends with ABC: "+ var4);
	   }

}
