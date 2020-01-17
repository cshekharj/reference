package com.chandra.algo.hackerrank;

import java.util.Scanner;

public class ArrayDiagonalDifference {

	public static void main(String[] args) {
		int n;
        Scanner in=new Scanner(System.in);
        n=in.nextInt();
        int board[][]=new int[n][n];
        int leftDiagonalArray[]=new int[n];
        int rigtDiagonalArray[]=new int[n];
        int leftDiagonalsum=0;
        int rightDiagonalsum=0;
        
        for(int row=0;row<board.length;row++){
        	for(int col=0;col<board[row].length;col++){
        		board[row][col] = in.nextInt();
        	}
        }
        
//        System.out.println("Array is ->");
        
        for(int row=0;row<board.length;row++){
        	for(int col=0;col<board[row].length;col++){
//        		System.out.print(board[row][col] + "\t");
        		if(row==col){
        			leftDiagonalArray[row]=board[row][col];
        			leftDiagonalsum+=board[row][col];
        		}
        		if(row+col == (board.length-1)){
        			rigtDiagonalArray[row]=board[row][col];
        			rightDiagonalsum+=board[row][col];
        		}
        	}
//        	System.out.println();
        }
        System.out.println(Math.abs(rightDiagonalsum-leftDiagonalsum));
        System.out.println(((float)leftDiagonalsum)/(board.length-1)+"\n");
//        System.out.println("Left Diagonal Array is ->");
//        for(int e:leftDiagonalArray)
//        	System.out.print(e + "\n\t");
//        System.out.println("Left Diagonal Sum is ->"+leftDiagonalsum);
//        
//        System.out.println("\nRight Diagonal Array is ->");
//        for(int r:rigtDiagonalArray)
//        	System.out.print(r + "\n\t");
//        System.out.println("Right Diagonal Sum is ->"+rightDiagonalsum);
        in.close();
    }

	
}
