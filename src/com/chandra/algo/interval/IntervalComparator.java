package com.chandra.algo.interval;

import java.util.Comparator;

public class IntervalComparator implements Comparator<IntervalData>{

	@Override
	public int compare(IntervalData o1, IntervalData o2) {
		return o1.from-o2.from;
	}
}
