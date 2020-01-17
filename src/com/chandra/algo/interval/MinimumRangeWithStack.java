package com.chandra.algo.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

//Merge overlapping zip code ranges from the series of ranges 
//from the input to cover all zip codes in less number of ranges
//Time Complexity - O(n Log n)  
//Space Complexity - O(1) stack space. 

public class MinimumRangeWithStack { 
	
	List<Range> rangeList = new ArrayList<>();
	

	/**
	 * @param rangeList
	 */
	public MinimumRangeWithStack(List<Range> rangeList) {
		this.rangeList = rangeList;
	}

	// The main method that takes a set of ranges, merges 
	// overlapping ranges and prints the result 
	public static void mergeRanges(Range arr[]) 
	{ 
		// Test if the given set has at least one interval 
		if (arr == null || arr.length <= 0) 
			throw new IllegalArgumentException("At lease one zip code range needs to be defined"); 
	
		// Create an empty stack of intervals 
		Stack<Range> stack=new Stack<>(); 
	
		// sort the intervals in increasing order of start time 
		Arrays.sort(arr,new Comparator<Range>(){ 
			public int compare(Range r1,Range r2) 
			{ 
				return r1.start-r2.start; 
			} 
		}); 
	
		// push the first range to stack 
		stack.push(arr[0]); 
	
		// Start from the next range and merge if necessary 
		for (int i = 1 ; i < arr.length; i++) 
		{ 
			// get range from stack top 
			Range top = stack.peek(); 
	
			// if current range is not overlapping with stack top, 
			// push it to the stack 
			if (top.end < arr[i].start) 
				stack.push(arr[i]); 
	
			// Otherwise update the ending time of top if ending of current 
			// range is more 
			else if (top.end < arr[i].end) 
			{ 
				top.end = arr[i].end; 
				stack.pop(); 
				stack.push(top); 
			} 
		} 
	
		// Print contents of stack 
		System.out.println();
		System.out.print("The minimum range restriction is -: "); 
		while (!stack.isEmpty()) 
		{ 
			Range t = stack.pop(); 
			System.out.print("["+t.start+","+t.end+"] "); 
		} 
	} 

	public static void main(String args[]) { 
		
		Range arr[]=new Range[3]; 
		//[94133,94133] [94200,94299] [94226,94399]
		arr[0]=new Range(94133,94133); 
		arr[1]=new Range(94200,94299); 
		arr[2]=new Range(94226,94399); 
		mergeRanges(arr); 
		
		//[94133,94133] [94200,94299] [94600,94699]
		arr[0]=new Range(94133,94133); 
		arr[1]=new Range(94200,94299); 
		arr[2]=new Range(94600,94699); 
		
		mergeRanges(arr); 
	}
} 

