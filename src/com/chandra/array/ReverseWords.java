package com.chandra.array;

public class ReverseWords {

	public static void main(String[] args) {
		String test="Apple love I";
		System.out.println("Original String -:"+test);
		char strArray[]=test.toCharArray();
		char c;
		
		/*for(int i=0;i<test.indexOf(" ", 0);i++)
			System.out.print(test.charAt(i));
		
		for(int j=test.length()-1;j>test.lastIndexOf(" ", test.length()-1);j--)
			System.out.print(test.charAt(j));*/
		
		for(int i=0,j=test.length()-1;i<strArray.length;i++,j--){
			strArray[i]=test.charAt(j);
		}
		
		System.out.print("Reversed String-");
		for(int m=0;m<strArray.length;m++)
			System.out.print(strArray[m]);
		test=new String(strArray);
		System.out.println();
		
		/*for(int l=0;l<strArray.length;l++){
			if(strArray[l] == ' ')
			for(int j=l,k = test.indexOf(" ", l)-1;k>=j;j++,k--){
				System.out.println("strArray[j]-"+strArray[j]);
				System.out.println("strArray[k]-"+strArray[k]);
				c=strArray[j];
				strArray[j]=strArray[k];
				strArray[k]=c;
			}
		}*/
		
		
			
			for(int j=0,k = test.indexOf(" ", j)-1;k>=j;j++,k--){
				System.out.println("strArray[j]-"+strArray[j]);
				System.out.println("strArray[k]-"+strArray[k]);
				c=strArray[j];
				strArray[j]=strArray[k];
				strArray[k]=c;
			}
		
		
		System.out.println("String with reveresed words -"+new String(strArray));
	}

}
