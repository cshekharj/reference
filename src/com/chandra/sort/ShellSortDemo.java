package com.chandra.sort;

import java.util.Random;

public class ShellSortDemo {

	private static int num = 50;
	private static int[] numbers = new int[num];
	
	public static void main(String args[]){
		
		//generate random numbers to sort
		Random random = new Random();
		for(int i=0;i<numbers.length;i++)
			numbers[i]=Math.abs(random.nextInt(100));			
		
		// print unsorted array
		printNumbers();
		// do shell sort
		doShellSort();
		// print sorted array
		printNumbers();
	}

	private static void doShellSort() {
		System.out.println("Running Shell Sort");
		int factor = numbers.length;
		
		while(factor >0){
			for(int i=factor;i<numbers.length;i++){
				int j=i;
				int tmp = numbers[i];
				while(j>=factor && numbers[j-factor]>tmp){
					numbers[j]=numbers[j-factor];
					j=j-factor;
					
				}
				numbers[j] = tmp;
			}
			if(factor == 2)
				factor=1;
			else
				factor *=(5.0/11);
		}
		
	}

	private static void printNumbers() {
		for(int i:numbers)
			System.out.print(i + " ");
		System.out.print("\n");
	}
}
