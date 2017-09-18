package com.chandra.algo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class WordCount {
	private static Map<String,Integer> wordMap = new TreeMap<String,Integer>();
	private static String filepath ="/Users/cjoshi/test.txt";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try ( Scanner scanner = new Scanner(new BufferedReader(new FileReader(filepath)));
				BufferedReader reader = new BufferedReader(new FileReader(filepath));
			) {
			
			
			int value=0;
			String word;
			while(scanner.hasNext()){
				word = scanner.next().replaceAll("[^a-zA-Z0-9_-]", "").toLowerCase();
				//System.out.println("word :-"+word);
				if(wordMap.get(word) != null){
					 value = wordMap.get(word);
					wordMap.put(word,value+1);
				}
				else{
					wordMap.put(word,1);
				}	
			}
			/*String line;
			while((line = reader.readLine()) != null){
				 String[] words = line.split(" ");
				for(String word:words){
					System.out.println("Word :-"+word);
					if(wordMap.get(word) != null){
						int value = wordMap.get(word);
						wordMap.put(word,value+1);
					}
					else{
						wordMap.put(word,1);
					}	
				}
			 }*/
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(Entry entry:wordMap.entrySet()){
			System.out.println("Word - "+entry.getKey()+" <---> "+"Count-"+entry.getValue());
		}
		wordMap.forEach((k,v)-> System.out.println("Word : " + k + " <---> Count : " + v));
		
	}
	

}