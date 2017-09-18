package com.chandra.algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class WordSort {

	public static void main(String[] args) {
		System.out.print("Enter the input string to sort characters :-");

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));) {
			String str = reader.readLine();
			System.out.println("Origina String-" + str);

			// initializing unsorted char array
			char cArr[] = str.toCharArray();

			// sorting array
			Arrays.sort(cArr);

			// let us print all the values available in list
			System.out.println("The sorted characters are -");
			for (char value : cArr) {
				System.out.print(value);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}