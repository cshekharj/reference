package com.chandra.algo;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class UniqueNumberInArray {
	
	private Map<Integer, Integer> duplicates = new HashMap<Integer, Integer>();
	
	public int singleNumber(int[] nums) {
		int unqiueInt = 0;
		System.out.print("The Array is - ");
		for (int i : nums){
			System.out.print(i+" ");
			Integer icount = (Integer) duplicates.get(i);
			if( icount == null){
				
				unqiueInt=i;
				duplicates.put(i,1);
			}else{
				duplicates.put(i,++icount);
			}
		}
		System.out.println("");
		if(duplicates.entrySet().size()>1)
        for(Entry e:duplicates.entrySet()){
        	if (e.getValue() == Integer.valueOf(1)){
        		System.out.println("Unique Number in array-"+e.getKey());
            	unqiueInt=(int)e.getKey();
        	}else{
        		System.out.println("Duplicate Number in array-"+e.getKey());
        	}
        }
		System.out.println("UNIQUE INT- "+unqiueInt);
        return unqiueInt;
    }

	public static void main(String args[]){
		int[] data = {-1,-1,-2};
		UniqueNumberInArray sn = new UniqueNumberInArray();
		sn.singleNumber(data);
	}
}
