package com.chandra.algo;

import java.util.HashSet;
import java.util.Set;

public class DuplicatesInArray {

	private Set<Integer> uniqueNumbers = new HashSet<Integer>();
	
	public int findDuplicate(int[] nums) {
        int dup=0;
        
        for(int i:nums){
        	if(uniqueNumbers.add(i)==false){
        		System.out.print(" "+i);
        		dup=i;
        	}
        }
		return dup;
    }
	
	public static void main(String args[]){
		int[] data = {1,1};
		DuplicatesInArray dups = new DuplicatesInArray();
		System.out.print("The array is - ");
		for(int i:data){
        	System.out.print(" "+i);
        }
		System.out.println("");
		System.out.print("The duplicates are - ");
		dups.findDuplicate(data);
		
	}
}
