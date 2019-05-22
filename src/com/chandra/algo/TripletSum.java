package com.chandra.algo;

import java.util.Scanner;

public class TripletSum {

	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		int[] numbers = { 2, 4, 3, 5, 7, 8, 9 };
		int[] numbersWithDuplicates = { 2, 4, 3, 5, 6, -2, 4, 7, 8, 9 };
		int targetSum = scanner.nextInt();
		
		findTripletsForSum (numbersWithDuplicates,10);
	}

	private static void findTripletsForSum(int[] numbersWithDuplicates, int target){
		int count,front,last=0;
		for(int i=0;i<numbersWithDuplicates.length;i++){
			front=numbersWithDuplicates[i];	
		}
	}
}
