package com.chandra.algo.interval;

import java.util.Arrays; 
import java.util.Comparator; 

// Merge overlapping zip code ranges from the series of ranges 
// from the input to cover all zip codes in less number of ranges
// Time Complexity - O(n Log n) due to sorting 
// Space Complexity - O(1) extra space. 
public class MinimumRanges { 
	// The main function that takes a set of intervals, merges 
	// overlapping intervals and prints the result 
	public static void mergeRanges(Range arr[]) 
	{ 
		// Sort Intervals in decreasing order of 
		// start time 
		Arrays.sort(arr,new Comparator<Range>(){ 
			public int compare(Range i1,Range i2) 
			{ 
				return i1.start - i2.start; 
			}
		}); 
	
		int index = 0; // Stores index of last element 
		// in output array (modified arr[]) 
	
		// Traverse all input Intervals 
		for (int i=0; i<arr.length; i++) 
		{ 
			// If this is not first Interval and overlaps 
			// with the previous one 
			if (index != 0 && arr[index-1].start <= arr[i].end) 
			{ 
				while (index != 0 && arr[index-1].start <= arr[i].end) 
				{ 
					// Merge previous and current Intervals 
					arr[index-1].end = Math.max(arr[index-1].end, arr[i].end); 
					arr[index-1].start = Math.min(arr[index-1].start, arr[i].start); 
					index--; 
				} 
			} 
			else // Doesn't overlap with previous, add to solution 
				arr[index] = arr[i]; 
			index++; 
		} 
	
		// Now arr[0..index-1] stores the merged Intervals 
		System.out.print("The Merged Intervals are: "); 
		for (int i = 0; i < index; i++) 
			System.out.print("["+arr[i].start+","+arr[i].end+"]"); 
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

class ZipRange 
{ 
	int start,end; 
	ZipRange(int start, int end) 
	{ 
		this.start=start; 
		this.end=end; 
	} 
} 

