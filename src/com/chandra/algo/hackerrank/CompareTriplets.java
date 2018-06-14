package com.chandra.algo.hackerrank;

import java.util.Scanner;

public class CompareTriplets {
	
	private static int aScore=0;
	private static int bScore=0;

	static int[] solve(int a0, int a1, int a2, int b0, int b1, int b2){
        // Complete this function
//		int score = 0,bScore=0;
		
		compare(a0, b0);
//		aScore+=score1[0];
//		bScore+=score1[1];
		
		compare(a1, b1);
//		aScore+=score2[0];
//		bScore+=score2[1];
		compare(a2, b2);
//		aScore+=score3[0];
//		bScore+=score3[1];
		
		System.out.println("aScore-"+aScore+"bScore-"+bScore);
		return new int[] {aScore,bScore};
    }
    
    private static void  compare(int a, int b){
//    	int aScore = 0,bScore=0;
		if (a>b)
			{aScore+=1;}
		else if(a<b)
			{bScore+=1;}
		
		System.out.println("aScore in method-"+aScore);
		System.out.println("bScore in method-"+bScore);
//		return new int[] {aScore,bScore};
	}
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a0 = in.nextInt();
        int a1 = in.nextInt();
        int a2 = in.nextInt();
        int b0 = in.nextInt();
        int b1 = in.nextInt();
        int b2 = in.nextInt();
        int[] result = solve(a0, a1, a2, b0, b1, b2);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");
        

    }

}
