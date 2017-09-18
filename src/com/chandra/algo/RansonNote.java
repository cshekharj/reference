package com.chandra.algo;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.StringTokenizer;

public class RansonNote {
    Map<String, Integer> magazineMap = new HashMap<String, Integer>();
    Map<String, Integer> noteMap = new HashMap<String, Integer>();
    
    public RansonNote(String magazine, String note) {
        StringTokenizer magTokenizer = new StringTokenizer(magazine," ");
        StringTokenizer noteTokenizer = new StringTokenizer(note," ");
        String word;
        while(magTokenizer.hasMoreTokens()){
        	word = magTokenizer.nextToken();
        	if(magazineMap.get(word) != null)
        		magazineMap.put(word, magazineMap.get(word)+1);
        	else{
        		magazineMap.put(word, 1);
        	}
        }
        
        while(noteTokenizer.hasMoreTokens()){
        	word = noteTokenizer.nextToken();
        	if(noteMap.get(word) == null)
        		noteMap.put(word, 1);
        	else{
        		noteMap.put(word, noteMap.get(word)+1);
        	}
        }
    }
    
    public boolean solve() {
    	boolean canDo=true;
    	if(noteMap.size() > magazineMap.size())
    		canDo=false;
    	
    	for(String word:noteMap.keySet()){
    		
    		if(!magazineMap.containsKey(word) || (magazineMap.get(word) < noteMap.get(word)) ){
    			canDo=false;
    			break;
    		}
    			
    	}
        return canDo;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        
        // Eat whitespace to beginning of next line
        scanner.nextLine();
        
        RansonNote s = new RansonNote(scanner.nextLine(), scanner.nextLine());
        scanner.close();
        
        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");
      
    }
}

