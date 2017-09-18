package com.chandra.sort;

public class SelectionSortDemo {

	private static int [] num ={1,5,7,19,11,24,4,2,3,9};
	public static void main(String[] args) {
		printArray(num);
		
		// do selection sort - compare i and i+1 elements and swap them if i+1th element is smaller..
		
		for(int i=0;i<num.length-1;i++){
			int index = i;
			for (int j = i + 1; j < num.length; j++){
	            if (num[j] < num[index]) 
	                index = j;
	  
	        int smallerNumber = num[index];  
	        num[index] = num[i];
	        num[i] = smallerNumber;
	        }
	        
		}
		printArray(num);
	}

	private static void printArray(int[] arr) {
		for(int i: arr)
			System.out.print(i+" ");
		System.out.println();
	}
}
