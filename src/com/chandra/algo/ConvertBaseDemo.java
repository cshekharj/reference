package com.chandra.algo;

public class ConvertBaseDemo {

	public static void convertBase(Integer number,int fromBase, int toBase) {

	    if (number == null)
	      throw new IllegalArgumentException("Invalid Input");
	    else{
	        int [] toBaseValue = new int [100];
	        for(int i=0;number>0;i++){
	            int val = Math.abs(number/toBase);
	            toBaseValue[i]=val;
	            number = val;
	        }
	        for(int j=toBaseValue.length-1;j>0;j--) {
	           if (toBaseValue[j] < 10)
	            System.out.print(toBaseValue[j]);
	           else
	               System.out.print(Integer.toHexString(toBaseValue[j]));
	        }
        }
    }
	public static void main(String[] args) {
		ConvertBaseDemo.convertBase(20, 2, 16);

	}

}
