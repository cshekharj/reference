package com.chandra.algo.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PhoneLetterCombo {
	private static final Scanner scanner = new Scanner(System.in);
	private static Map<Character, char[]> letterMap = new HashMap<>();
	
	static {
		letterMap.put('0', new char[] {});
		letterMap.put('1', new char[] {});
		letterMap.put('2', new char[] { 'a', 'b', 'c' });
		letterMap.put('3', new char[] { 'd', 'e', 'f' });
		letterMap.put('4', new char[] { 'g', 'h', 'i' });
		letterMap.put('5', new char[] { 'j', 'k', 'l' });
		letterMap.put('6', new char[] { 'm', 'n', 'o' });
		letterMap.put('7', new char[] { 'p', 'q', 'r', 's' });
		letterMap.put('8', new char[] { 't', 'u', 'v' });
		letterMap.put('9', new char[] { 'w', 'x', 'y', 'z' });
	}

	public static void main(String[] args) {
		int charIndex=0;
		List<String> combinations = new ArrayList<>();
		String phoneNumber = scanner.nextLine();
		System.out.println("Length-" + phoneNumber.length());
		StringBuilder phoneDigits = new StringBuilder();
		letterCombinations(phoneNumber, phoneDigits, combinations,charIndex);

		combinations.stream().forEach(y->System.out.println(y+" "));
//		for (String str : combinations)
//			System.out.print(str + " ");
	}

	private static void letterCombinations(String phoneNumber, StringBuilder phoneDigits, List combinations, int charIndex) {
		
		System.out.println("phoneDigits-"+phoneDigits);
		if (phoneNumber.length() == phoneDigits.length()) {
			combinations.add(phoneDigits.toString());
			return;
		}
		
		for (char c : letterMap.get(phoneNumber.charAt(charIndex))){
			System.out.println("char-" + c);
			phoneDigits.append(c);
			letterCombinations(phoneNumber, phoneDigits, combinations,charIndex+1);
			phoneDigits.deleteCharAt(phoneDigits.length() - 1);
		}
	}

}
