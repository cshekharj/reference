package com.chandra.algo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;


/**
 * @author cjoshi
 *
 */
public class AnagramFinder {

	private static Map<String,List<String>> wordMap = new HashMap<String,List<String>>();
	private static String filepath ="/Users/cjoshi/AnagramTest.txt";
		/**
		 * @param args
		 */
		public static void main(String[] args) {
			try ( Scanner scanner = new Scanner(new BufferedReader(new FileReader(filepath)));
					BufferedReader reader = new BufferedReader(new FileReader(filepath));
				) {
				String word,anagram;
				while(scanner.hasNext()){
					word = scanner.next().replaceAll("[^a-zA-Z0-9_-]", "").toLowerCase();
					
					anagram = getSortedCharacters(word);
					List<String> wordlist = wordMap.get(anagram);
					if(wordlist == null)
						wordMap.put(anagram, wordlist=new ArrayList<String>());
					wordlist.add(word);
					
				}		
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			for(Entry entry:wordMap.entrySet()){
				if(((List<String>) entry.getValue()).size()>1)
					
					System.out.println("Word - "+entry.getKey().toString()+" <---> "+"Count-"+ entry.getValue());
			}
			//wordMap.forEach((k,v)-> System.out.println("Word : " + k + " <---> Count : " + v));
			
		}
			
		/**
		 * @param word
		 * @return
		 */
		private static String getSortedCharacters(String word){
			char [] wordArr = word.toCharArray();
			Arrays.sort(wordArr);
			return new String(wordArr);
		}
	}
class AnagramKey{
	String root;
	List<String> words=new ArrayList<String>();
	public String getRoot() {
		return root;
	}
	public void setRoot(String root) {
		this.root = root;
	}
	public List<String> getWords() {
		return words;
	}
	public void setWords(List<String> words) {
		this.words = words;
	}
	
	
}