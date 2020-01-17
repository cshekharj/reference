package com.caffeine.store;

import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class DataStore {
	
	public static final String filepath="/Users/gayatri/Downloads/interview-in-memory-database-master/inputs/BASICS_1.txt";
	
	private boolean isTXNenabled=false;
	
	/*enum Command{
		get ("GET"),
		set ("SET");
		
		private String command;
		
		Command(String command){
			this.command=command;
		}
		
		public String getCommand(){
			return command;
		}
	}*/

	Map<Object,Object> dataStore = new HashMap<>();
	/*
	 * Use this for setting or updating a value for the given key
	 * */
	public void set(Object key, Object value){
		// fail fast..
		if(key == null)
			throw new IllegalArgumentException("Key cannot be null");
		
		try{
			dataStore.put(key, value);
		}
		catch(Exception e){
			System.out.println("Exception occured while setting value-"+value+"to key-"+key);
			e.printStackTrace();
		}
		
	}
	/*
	 * returns the value for the parameter key, throws IllegalArgumentException if key is null
	 * 
	 * */
	public Object get(Object key){
		Object value=null;
		if(key ==  null)
			throw new IllegalArgumentException("Key cannot be null");
		
		try{
			value=dataStore.get(key);
		}
		catch(Exception e){
			System.out.println("Exception occured while getting value for key-"+key);
			e.printStackTrace();
		}
		 return value;
	}
	
	/*
	 * removes the key-value pair from the data store for the parameter key, throws IllegalArgumentException if key is null
	 * 
	 * */
	public void unset(Object key){
		if(key ==  null)
			throw new IllegalArgumentException("Key cannot be null");
		
		try{
			dataStore.remove(key);
		}
		catch(Exception e){
			System.out.println("Exception occured while unsetting value for key-"+key);
			e.printStackTrace();
		}
	}

	/*
	 * checks if the given parameter key exits in the data store, throws IllegalArgumentException if key is null
	 * 
	 * */
	public boolean exists(Object key){
		if(key ==  null)
			throw new IllegalArgumentException("Key cannot be null");
		
		return dataStore.containsKey(key);
		
	}
	
	public static String getSupportedCommand(String string) {
		
		return null;
	}
	
	private void process(String line) {
		System.out.println(line);
		String []tokens = line.split(" ");
		//don't handle non-commands
		// = getSupportedCommand(tokens[0]);
		System.out.println(tokens[0]);
		if("BEGIN".equals(tokens[0].toUpperCase(Locale.ENGLISH)));
			
		
		/*for(String token:tokens){
			System.out.println(token );
		}*/
	}
	
	public static void main(String args[]){
		DataStore datasore = new DataStore();
		try(Scanner scanner=new Scanner(new File(filepath))){
			//process lines from the file
			while(scanner.hasNext() == true)
				datasore.process(scanner.nextLine());
			scanner.close();
		}catch(Exception e){
			System.out.println("Exception occured while reading input file");
			e.printStackTrace();
		}
	}

	

	
}

