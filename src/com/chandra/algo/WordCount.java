package com.chandra.algo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class WordCount {
	private static Map<String, Integer> wordMap = new TreeMap<String, Integer>();
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
		
		/*for(Entry entry:wordMap.entrySet()){
			System.out.println("Word - "+entry.getKey()+" <---> "+"Count-"+entry.getValue());
		}*/
		//wordMap.forEach((k,v)-> System.out.println("Word : " + k + " <---> Count : " + v));
		
		System.out.println("<------------------------>");
		// sort map by value
		/*SortedSet<Map.Entry<String, Integer>> sortedSet = new TreeSet<Map.Entry<String, Integer>>(
				new Comparator<Map.Entry<String, Integer>>() {
					@Override
					public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
						return e2.getValue().compareTo(e1.getValue());
					}
				});
		sortedSet.addAll(wordMap.entrySet());*/
		//sortedSet.forEach((Entry e)-> System.out.println("Word : " + e.getKey() + " <---> Count : " + e.getValue()));
		
		
		Set<Entry<String, Integer>> set = wordMap.entrySet();
		List<Entry<String, Integer>> wordlist = new ArrayList<Entry<String, Integer>>(set);
		Collections.sort(wordlist, new Comparator<Map.Entry<String, Integer>>() {
				public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
					return o2.getValue().compareTo(o1.getValue());
				}
			});
		
		wordlist.forEach((Entry e) -> System.out.println("Word : " + e.getKey() + " <---> Count : " + e.getValue()));
	}
}
