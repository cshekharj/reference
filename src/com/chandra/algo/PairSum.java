package com.chandra.algo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Shekhar 
 * 		Pair sum in various ways - given an integer array and a
 *      target sum - find all pairs of integers in the array that add up to
 *      the target sum
 *
 */

public class PairSum {

	private static final Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		int[] numbers = { 2, 4, 3, 5, 7, 8, 9 };
		int[] numbersWithDuplicates = { 2, 4, 3, 5, 6, -2, 4, 7, 8, 9 };
		int targetSum = scanner.nextInt();
		//findSumPairsInefficent(numbersWithDuplicates,targetSum);
		//findSumPairsEfficent(numbersWithDuplicates,targetSum);
		findSumPairsWithSet(numbers,targetSum);
	}
	
	private static void findSumPairsWithSet(int[] numbers, int targetSum) {
		Set<Number> set=new HashSet<>(numbers.length);
		for(int i:numbers){
			int target=targetSum-i;
			if(!set.contains(target)){
				set.add(i);
			}else{
				System.out.printf("Sum pair - (%d, %d) %n", i, target);
			}
		}
	}

	private static void findSumPairsEfficent(int[] numbers, int targetSum) {
		Arrays.sort(numbers);
		int left=0;
		int right=numbers.length-1;
		int sum=0;
		while(left<right){
			sum=numbers[left]+numbers[right]; 
			if(sum==targetSum){
				System.out.printf("Sum pair - (%d,%d) %n", numbers[left],numbers[right]);
				left=left+1;
				right=right-1;
			}
			else if(sum<targetSum)
				left=left+1;
			else if(sum>targetSum)
				right=right-1;
		}
		
	}

	/*
	 * Inefficient time complexity - O(n^2) - where n is the size of input integer array
	 * 
	 */
	private static void findSumPairsInefficent(int[] numbers, int targetSum) {
		int first, next = 0;
		for (int i = 0; i < numbers.length; i++) {
			first = numbers[i];
			for (int j = i + 1; j < numbers.length; j++) {
				next = numbers[j];
				if (first + next == targetSum) {
					System.out.printf("Sum pairs-(%d, %d) %n",first,next);
				}
			}
		}

	}
	
	

}
