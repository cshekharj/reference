package com.chandra.algo.hackerrank;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class PlusMinus {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int n;
        Scanner in=new Scanner(System.in);
        n=in.nextInt();
        int[] array= new int[n];
        BigDecimal plusCount=new BigDecimal("0");
        BigDecimal minusCount=new BigDecimal("0");
        BigDecimal zeroCount=new BigDecimal("0");
        BigDecimal One=new BigDecimal("1");
        BigDecimal arrayLength=new BigDecimal(array.length);
        
        for(int col=0;col<array.length;col++){
            array[col] = in.nextInt();
            System.out.println("array[col]"+array[col]);
            if(array[col]>0)
                plusCount=plusCount.add(One);
            else if(array[col]<0)
                minusCount=minusCount.add(One);;
            if(array[col]==0)
                zeroCount=zeroCount.add(One);
        }
        
        System.out.println("plusCount"+plusCount);
        System.out.println("array.length"+array.length);
        BigDecimal plusScore  = plusCount.divide(arrayLength,6,RoundingMode.HALF_UP);
        BigDecimal minusScore  = minusCount.divide(arrayLength,6,RoundingMode.HALF_UP);
        BigDecimal zeroScore  = zeroCount.divide(arrayLength,6,RoundingMode.HALF_UP);
        
        System.out.printf(plusScore+"\n");
        System.out.printf(minusScore+"\n");
        System.out.printf(zeroScore+"\n");
    }
}
