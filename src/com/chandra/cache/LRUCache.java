package com.chandra.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer, String> {
	private static final long serialVersionUID = 1L;
	   private int capacity;
	    
	   public LRUCache(int capacity, float loadFactor){
	      super(capacity, loadFactor, true);
	      this.capacity = capacity;
	   }
	    
	   /**
	    * removeEldestEntry() should be overridden by the derivative, otherwise it will not 
	    * remove the oldest object from the Map - the one passed as parameter. If returned 
	    * true map entry that has been accessed least number of times will be removed
	    */
	   protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest){
	      return size() > this.capacity;
	   }
	    
	   public static void main(String arg[]){
		   LRUCache lruCache = new LRUCache(4, 0.75f);
	       
	      lruCache.put(1, "Object1");
	      lruCache.put(2, "Object2");
	      lruCache.put(3, "Object3");
	      lruCache.get(1);
	      lruCache.put(4, "Object4");
	      System.out.println("Cache-"+lruCache);
	      lruCache.put(5, "Object5");
	      lruCache.get(3);
	      lruCache.put(6, "Object6");
	      System.out.println("Cache-"+lruCache);
	      lruCache.get(4);
	      lruCache.put(7, "Object7");
	      lruCache.put(8, "Object8");
	      System.out.println("Cache-"+lruCache);
	   }

}
