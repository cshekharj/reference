package com.chandra.array;
/*
 * Given an array of integers of size n 
 * print all combinations of elements in an array of size r 
 * E.g. Given array {2,1,3,4,5} of 5 elements and  size :- r=2, the combinations
 * are - 
 * {2,1} {2,3} {2,4} {2,5}
 * {1,3} {1,4} {1,5}
 * {3,4} {3,5}
 * {4,5}
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayCombination {

	private static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int size=0;
		int[] numbers = new int[5];
		List<Integer> combos = new ArrayList<>();
		//get elements in an array
		System.out.println("Enter the elements of the array");
		for(int i=0;i<numbers.length;i++)
			numbers[i]=in.nextInt();
		// get combo size
		System.out.println("Enter the size of combinations");
		size = in.nextInt();
		printCombinations(0,numbers,combos,size);
		in.close();
	}
	private static void printCombinations(int index,int[] numbers,List<Integer> combos, int comboSize){
		if(combos.size() == comboSize){
			for(int i:numbers){
				System.out.print("{"+i+"}");
				return;
			}
		}

	for(int i=0;i<=numbers.length 
			&& numbers.length-i>=comboSize-index;i++ ){
			combos.add(numbers[i]);
			printCombinations(index+1,numbers,combos,comboSize);
		}
	}
}
