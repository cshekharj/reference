package com.chandra.array;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Shekhar
 * https://www.hackerrank.com/challenges/sock-merchant/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
 * Given total number of socks and an array of colors - find total number of distinct pairs
 * For example, there are n=7 socks with colors ar=[1,2,1,2,1,3,2]. 
 * There is one pair of color 1 and one of color 2. 
 * There are three odd socks left, one of each color. The number of pairs is 2.
 */
public class DistinctPairOfSocks {

	private static final Scanner scanner = new Scanner(System.in);
    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
    
    	int result = 0;
    	Map<Integer,Integer> colorPairMap = new HashMap<>();
    	for(int i:ar){
    		if(colorPairMap.containsKey(i)){
    			colorPairMap.put(i,colorPairMap.get(i)+1);
    		}
    		else
    			colorPairMap.put(i, 1);
    	}
    	for(int k :colorPairMap.keySet()){
    		result=result+colorPairMap.get(k)/2;
    	}
    	return result;
    }

    

    /**
     * @param args
     * @throws IOException
     */
    /**
     * @param args
     * @throws IOException
     */
    /**
     * @param args
     * @throws IOException
     */
    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
    	int num = 7;
    	int[] colors = {1,2,1,2,1,3,2};
    	int result = sockMerchant(num, colors);
    	System.out.println("result -"+ result);
        /*BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();*/
    }
}
