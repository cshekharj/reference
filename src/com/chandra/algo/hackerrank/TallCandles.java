package com.chandra.algo.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class TallCandles {

	static int birthdayCakeCandles(int n, int[] ar) {
        // Complete this function
		Arrays.sort(ar);

		int nCandles=0;
		int max=ar[ar.length-1];
		System.out.println(max+"max ");
		for(int i=0;i<ar.length;i++){
			System.out.println("ar[i]"+ar[i]);
			if(ar[i]==max)
				 nCandles+=1;
		}
			return nCandles;	
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < ar.length; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = birthdayCakeCandles(n, ar);
        System.out.println("\n"+result);
    }
}
