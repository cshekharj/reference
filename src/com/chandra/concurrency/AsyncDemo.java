package com.chandra.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncDemo {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();

		executorService.execute(new Runnable() {
		    public void run() {
		    	try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        System.out.println("Asynchronous task");
		    }
		});
		System.out.println("Doing Something");
		executorService.shutdown();

	}

}
