package com.chandra.algo.recursion;

import java.util.Scanner;

public class KeyPadPermutations {
	private static final Scanner scanner = new Scanner(System.in);
    public void permute(int input[]) {
        char result[] = new char[input.length];
        permute(input,0,result);
    }

    private void permute(int input[], int pos, char result[]) {
        if (pos == input.length) {
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i]);
            }
            System.out.println();
            return;
        }

        char[] str = getCharSetForNumber(input[pos]);
        for (char ch : str) {
            result[pos] = ch;
            permute(input, pos+1, result);
        }
    }

    private char[] getCharSetForNumber(int num) {
        switch(num){
        	case 0 : return "".toCharArray();
            case 1 : return "abc".toCharArray();
            case 2 : return "def".toCharArray();
            case 3 : return "ghi".toCharArray();
            case 4 : return "jkl".toCharArray();
            case 5 : return "mno".toCharArray();
            case 6 : return "pqrs".toCharArray();
            case 8 : return "tuv".toCharArray();
            case 9 : return "wxyz".toCharArray();
        }
        throw new IllegalArgumentException();
    }
    
    public static void main(String args[]){
        int input[] = {1,2,3};
        KeyPadPermutations kpp = new KeyPadPermutations();
        kpp.permute(input);
    }
}
