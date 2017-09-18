package com.chandra.algo.interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntervalImpl implements Interval {

	private List<IntervalData> intervalList = new ArrayList();

	public int getTotalCoveredLength(){
 
     int length = 0 ;
     Collections.sort(intervalList, new IntervalComparator());
 
      IntervalData startInv = (IntervalData) intervalList.get(0);
 
      for(int i=1;i<intervalList.size();i++){
    	  IntervalData interval = (IntervalData) intervalList.get(i);
        if(startInv.to > interval.from){
        	startInv.to = Math.max(startInv.to, interval.to); 
        }else{
        	startInv=interval;
             length = length + startInv.to-startInv.from;
        }
      }
      return length = length + startInv.to-startInv.from;
 }

	@Override
	public void addInterval(int from, int to) {
		if((from >0) && (to > 0) && from < to){
			intervalList.add(new IntervalData(from, to));
		}

	}
	
	public static void main(String[] args) {
		Interval intervals = new IntervalImpl();
        intervals.addInterval(3, 6);
        intervals.addInterval(8, 9);
        intervals.addInterval(1, 5);
         
        int len = intervals.getTotalCoveredLength();
         
        System.out.println(len);
    }
}
