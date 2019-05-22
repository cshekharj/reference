package com.chandra.array;

import java.util.Scanner;

import com.chandra.util.Utility;

public class RotateArrayDemo {

    public static int[] arrayLeftRotation(int[] a, int n, int k) {
    	
		for(int num=0;num<n;num++){
    		int tmp =0;
    		int last = a[a.length-1];
        	int first = a[0];
			for (int i=0,j=i+1;i<a.length-1;i++,j++){
				tmp = a[i];
				a[i] = a[j];
			}
			a[a.length-1]=first;
		}
		return a;
    }
    
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        
        System.out.println("Array before Operation");
        Utility.printArray(a);
        
        int[] output = arrayLeftRotation(a, k, k);
        System.out.println("Array after Operation");
        Utility.printArray(output);
      
    }
}

