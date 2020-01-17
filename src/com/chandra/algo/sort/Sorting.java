package com.chandra.algo.sort;

public class Sorting {

	public static void main(String[] args) {
		int arr[]={ 5, 7, 8, 9,2, 4, 3};
		Sorting sort=new Sorting();
		System.out.println("Given Array");
		sort.printArray(arr);
		sort.selectionSort(arr);
		System.out.println("Sorted Array");
		sort.printArray(arr);

	}

	private void printArray(int[] arr) {
		for(int i:arr)
			System.out.print(i+" ");
		System.out.println();
	}

	private void selectionSort(int[] arr) {
		int n=arr.length;
		
		for(int i=0;i<n-1;i++){
			int minIdx=i;
			for(int j=i+1;j<n;j++){
				if(arr[j]<arr[minIdx])
					minIdx=j;
				int temp=arr[minIdx];
				arr[minIdx]=arr[i];
				arr[i]=temp;
			}
		}
		
	}

}
