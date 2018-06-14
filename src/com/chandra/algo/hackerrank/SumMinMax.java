package com.chandra.algo.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class SumMinMax {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
      
        long[] array = new long[n];
        long minSum=0,maxSum=0;
        
        
        for(int i=0;i<(array.length);i++)
        		array[i]=in.nextLong();
        		
        Arrays.sort(array);
        
		        for(int i=0;i<(array.length-1);i++)
		    			minSum+=array[i];
		    
		        
		        for(int j=(array.length-1);j>0;j--)
					maxSum+=array[j];
        
        System.out.println(minSum+" "+maxSum);
        in.close();
    }
}
