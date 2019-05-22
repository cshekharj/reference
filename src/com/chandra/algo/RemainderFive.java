package com.chandra.algo;

public class RemainderFive {
	
	public static void main(String[] args) {
		int number=0;
		int remainder=0;
		int maxNumber=1000000000;
		int temp=0;
		
		for(temp=1;temp<maxNumber;temp++){	
			//System.out.println("temp-"+temp);
			number=temp;
			number=number*2+10;
			//System.out.println("number-"+number);
			number=number/2;
			//System.out.println("number-"+number);
			remainder = number-temp;
			//System.out.println("remainder-"+remainder);
			if(remainder != 5)
				System.out.println("remainder-"+remainder);
		}
		
	}

}
