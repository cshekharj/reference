package com.chandra.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorDemo {

	public static void main(String[] args) {
		
		Integer count =0;
		BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(50);
		
		DemoThreadPoolExecutor executor = new DemoThreadPoolExecutor(5,
                10, 50, TimeUnit.MILLISECONDS, queue);
		
		executor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
			
			@Override
			public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
				 System.out.println("DemoTask Rejected : "
	                        + ((DemoThread) r).getName());
	                System.out.println("Waiting for a second !!");
	                try {
	                    Thread.sleep(1000);
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	                System.out.println("Lets add another time : "
	                        + ((DemoThread) r).getName());
	                executor.execute(r);
				
			}
		});
		// Let start all core threads initially
		
		long starttime = System.currentTimeMillis();
        executor.prestartAllCoreThreads();
        while (true) {
        	count++;
            // Adding threads one by one
            System.out.println("Adding DemoTask : " + count);
            executor.execute(new DemoThread(count.toString()));
 
            if (count == 100)
                break;
        }
        executor.shutdown();
       
		System.out.println("Time takes in milliseconds :-"+(System.currentTimeMillis()-starttime));
    }
}
