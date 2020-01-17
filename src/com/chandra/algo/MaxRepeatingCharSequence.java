/**
 * 
 */
package com.chandra.algo;

/**
 * @author Shekhar
 *
 */
public class MaxRepeatingCharSequence {

	static char getMaxRepeatingChar(String str){
		
		int n = str.length(); 
        int count = 0; 
        char res = str.charAt(0); 
        int cur_count = 1; 
		
		for(int i=0;i<n;i++){
			if(i<n-1&& str.charAt(i)==str.charAt(i+1))
				cur_count++;
			else{
				if(cur_count>count){
					count=cur_count;
					res=str.charAt(i);
				}
				cur_count=1;
			}
		}
		return res;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str="xxyyyzzaabbccde";
		System.out.println("The character with max consecutive repeating sequence is - "+getMaxRepeatingChar(str));

	}

}
