package com.chandra.sort;

public class BuubleSortDemo {
	private static int [] num ={1,5,7,19,11,24,4,2,3,9};
	
	public static void main(String[] args) {
		int temp;
		
		printArray(num);
		
		for(int j=num.length;j>=0;j--){	 
			int count=0;
			for(int i=0;i<num.length-1;i++){
				int k = i+1;
				if(num[i]>num[k]){
					temp = num[i];
					num[i]=num[k];
					num[k]=temp;
				}else
					count++;
				if (count == i - 1) {
					break;
					}
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
