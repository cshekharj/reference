package com.chandra.algo;

import java.util.Arrays;
import java.util.HashSet;

public class TripletSum {

	public static void main(String[] args) {
		int[] numbers = { 2, 4, 3, -5, 7, 8, 9 };
		int[] numbersWithDuplicates = { 2, 4, 3, 5, 6, 2, 4, 7, 8, 9 };
		TripletSum tsum = new TripletSum();
		
		// find triplets with brute force
//		System.out.println("--findTripletsForSum--");
//		tsum.findTripletsForSum(numbers,0);
//		tsum.findTripletsForSum(numbers,10);
//		tsum.findTripletsForSum(numbersWithDuplicates,0);
//		tsum.findTripletsForSum(numbersWithDuplicates,10);
		
		//find triplet with hashing
//		System.out.println("--findTripletsForSumWithHashing--");
//		tsum.findTripletsForSumWithHashing(numbers,0);
//		tsum.findTripletsForSumWithHashing(numbers,10);
//		tsum.findTripletsForSumWithHashing(numbersWithDuplicates,0);
//		tsum.findTripletsForSumWithHashing(numbersWithDuplicates,10);
		
		//findTripletsForSumWithSorting
//		System.out.println("--findTripletsForSumWithSorting--");
//		tsum.findTripletsForSumWithSorting(numbers,0);
//		tsum.findTripletsForSumWithSorting(numbers,10);
//		tsum.findTripletsForSumWithSorting(numbersWithDuplicates, 0);
//		tsum.findTripletsForSumWithSorting(numbersWithDuplicates, 10);
		
		//findTripletsLessThanSum
		System.out.println("--findTripletsLessThanSum--");
		tsum.findTripletsLessThanSum(numbers, 8);
	}
	/*
	 * Brute force approach 
	 * Time -  O (n^3)
	 * Space - O(1)
	 */
	private void findTripletsForSum(int[] numbersWithDuplicates, int target){

		for(int i=0;i<numbersWithDuplicates.length;i++) // 1st loop from start to end
			for(int j=i+1;j<numbersWithDuplicates.length-1;j++)// 2nd loop from start+1 to end-1
				for(int k=j+1;k<numbersWithDuplicates.length-2;k++){//3rd loop from start+2 to end-2
					if(numbersWithDuplicates[i]
						+numbersWithDuplicates[j]
							+numbersWithDuplicates[k] == target){
						System.out.println("Triplet for sum "+target+" is -: "
								+numbersWithDuplicates[i]+" "
								 +numbersWithDuplicates[j]+" "
								 +numbersWithDuplicates[k]);
					}
				}
			
	}
	/*
	 * Hashing
	 * Time - O(n^2)
	 * Space - O(n)
	 */
	private void findTripletsForSumWithHashing(int arr[], int sum){
		
		// go from 0 to array length -2 one at a time
		for(int i=0;i<arr.length-2;i++){
			// initialize new hashset
			HashSet<Integer> hashset = new HashSet<>();
			//get the value of (sum - 1st no) in array
			int curr_sum=sum-arr[i];
			// go from 2nd no in array to last number
			for(int j=i+1;j<arr.length-1;j++){
				// if hashset contains (sum-1st no)-jth no and 
				// last no in hashset is not (sum-1st no)-jth no
				// then it's triplet with desired sum
				if(hashset.contains(curr_sum-arr[j]) && 
						curr_sum - arr[j] != (int)hashset.toArray()[hashset.size() - 1]){
					System.out.printf("Triplet for sum "+sum+" is -: %d %d %d ",arr[i],arr[j],curr_sum-arr[j]);
					System.out.println();
				}
				else{
					// if we didn't get desired sum, add jth no to hashset
					hashset.add(arr[j]);
				}
					
			}
		}
	}
	
	/*
	 * Sorting 
	 * Time - O(n^2)
	 * Space - O(1)
	 */
	private void findTripletsForSumWithSorting(int arr[], int sum){
		
		//sort the array.
		Arrays.sort(arr);
		//go from 0th element to length-2th element
		for(int i=0;i<arr.length-2;i++){
			//set front to 2nd element
			int front=i+1;
			//set back to second last element
			int back=arr.length-1;
			// do until front is less than back
			while(front<back){
				// if ith+front'th+back'th sum is desired sum, a triplet is found
				// increment front & decrement back
				if(arr[i]+arr[front]+arr[back] == sum){
					System.out.printf("Triplet for sum "+sum+" is -: %d %d %d ",arr[i],arr[front],arr[back]);
					System.out.println();
					front++;
					back	--;
				}
				// if ith+front'th+back'th sum less desired sum, increment front only
				else if (arr[i]+arr[front]+arr[back] < sum)
					front++;
				else // if ith+front'th+back'th sum more desired sum, decrement back only
					back	--;
			}
			
		}
		
	}
	
	private void findTripletsLessThanSum(int arr[], int sum){
		
		//sort the array.
				Arrays.sort(arr);
				//go from 0th element to length-2th element
				for(int i=0;i<arr.length-2;i++){
					//set front to 2nd element
					int front=i+1;
					//set back to second last element
					int back=arr.length-1;
					// do until front is less than back
					while(front<back){
						// if ith+front'th+back'th sum is desired sum, a triplet is found
						// increment front & decrement back
						if(arr[i]+arr[front]+arr[back] == sum){
							//System.out.printf("Triplet for sum "+sum+" is -: %d %d %d ",arr[i],arr[front],arr[back]);
							//System.out.println();
							front++;
							back	--;
						}
						// if ith+front'th+back'th sum less desired sum, increment front only
						else if (arr[i]+arr[front]+arr[back] < sum){
							System.out.printf("Triplets with sum less that "+sum+" is -: %d %d %d ",arr[i],arr[front],arr[back]);
							System.out.println();
							front++;
						}else // if ith+front'th+back'th sum more desired sum, decrement back only
							back	--;
					}
					
				}
	}
}
