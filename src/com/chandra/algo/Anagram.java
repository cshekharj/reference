package com.chandra.algo;
import java.util.*;
import java.io.*;

public class Anagram {
	private static String filepath ="/Users/cjoshi/AnagramTest.txt";
    public static void main(String[] args) {
    String beta = "post";

        try {

            Map<String, List<String>> m = 
                   new HashMap<String, List<String>>();

            Scanner s = new Scanner(new BufferedReader(new FileReader(filepath)));
            while (s.hasNext()) {
                String word = s.next();
                String alpha = sorting(word);
                List<String> l = m.get(alpha);
                if (l == null)
                    m.put(alpha, l=new ArrayList<String>());
                l.add(word);
            }

         List<String> l = m.get(sorting(beta));
       for(String str:l){
    	   System.out.println("word-"+str);
       }
       s.close();
        } 
    catch (Exception e) {
            System.out.println(e);
            System.exit(1);
        }
    }

    private static String sorting(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}