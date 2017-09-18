package com.chandra.algo;

import java.util.Arrays;

public class RecursiveBinarySearch {

	public static void main(String[] args) {
		RecursiveBinarySearch rsbSearch = new RecursiveBinarySearch();
		int arr[] = {10,20,30,40,50,60,71,80,90,91};
        int x = 91;
		System.out.print("Array is - ");
		Arrays.stream(arr).forEach(i ->System.out.print(i+" "));
		System.out.println("");
		System.out.println("Searcing for - "+x);
        
        int position = rsbSearch.binarySearch(arr, x);
        if (position == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index "+position);

	}

	private int binarySearch(int[] data, int searchInt){
		int left = 0, right = data.length-1;
		while(left <= right){
			//get mid if the array
			int mid = left + (right - left)/2;
			
			// if searchInt is at mid return mid
			if(data[mid] == searchInt) 
				return mid;
			
			// if searchInt is beyond mid ignore first half of array
			if(data[mid] < searchInt)
				left = mid+1;
			else //Ignore second half of array
				right = mid -1;
		}
		
		return -1; //did not find searchInt
		
	}
}
