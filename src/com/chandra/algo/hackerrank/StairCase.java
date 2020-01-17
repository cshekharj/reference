package com.chandra.algo.hackerrank;

import java.util.Scanner;

public class StairCase {

	public static void main(String[] args) {
		int n;
        Scanner in=new Scanner(System.in);
        n=in.nextInt();

        for(int row=0,limit=n;row<n;row++,limit--){
	        	for(int col=0;col<n;col++){
	        		if(col<limit-1)
	        			System.out.print(" ");
	        		else
	        			System.out.print("#");
	        	}	
	        	System.out.println();
        }
        /*int c=1;
        for(int row=1;row<=n;row++){
        		for(int col=0;col<=n;col++)
	        		System.out.print("");
	        	for(int col=0;col<=n;col++){
	        		if(col % 2 ==0)
	        			System.out.print(" ");
	        		else
	        			System.out.print("#");
	        	}	
	        	c+=2;
	        	System.out.println();
        }*/
	}

}
