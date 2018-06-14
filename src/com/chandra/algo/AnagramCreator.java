package com.chandra.algo;

import java.util.Arrays;
import java.util.Scanner;
public class AnagramCreator {
    /**
     * @param first
     * @param second
     * @return
     */
    public static int numberNeeded(String first, String second) {
    	/*int[] freq = new int[26];
        first.chars().forEach((c) -> {
            freq[c -'a']++;
        });
        second.chars().forEach((c) -> {
            freq[c - 'a']--;
        });
        return Arrays.stream(freq).map(Math::abs).sum();*/
    	int[] chars = new int[26]; // max alphas in ENG
    	for(char c:first.toCharArray()){
    		chars[c-97]=chars[c-97]+1;
    	}
    	for(char c:second.toCharArray()){
    		chars[c-97]=chars[c-97]-1;
    	}
    	int num = 0;	
    	for(int i:chars){
    		num=num+Math.abs(i);
    	}
    	return num;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
        in.close();
    }
}
