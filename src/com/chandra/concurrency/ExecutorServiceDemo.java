package com.chandra.concurrency;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class ExecutorServiceDemo {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService executorService = new ThreadPoolExecutor(
                5,
                10,
                50,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>()
                );
		
		((ThreadPoolExecutor) executorService).setRejectedExecutionHandler(new RejectedExecutionHandler() {
			
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
		
		Set<Callable<String>> callables = new HashSet<Callable<String>>();

		callables.add(new Callable<String>() {
		    public String call() throws Exception {
		    	System.out.println("Executing 1");
		        return "Task 1";
		    }
		});
		callables.add(new Callable<String>() {
		    public String call() throws Exception {
		    	System.out.println("Executing 2");
		       throw new Exception("Throwing exception");
		    	//return "Task 2";
		    }
		});
		callables.add(new Callable<String>() {
		    public String call() throws Exception {
		    	System.out.println("Executing 3");
		        return "Task 3";
		    }
		});

		try {
			List<Future<String>> resultList= executorService.invokeAll(callables);
			
			for(Future<String> result:resultList){
				System.out.println("future.get = " +result.get());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception Occured - "+e.getCause()+e.getMessage());
		}
		executorService.shutdown();

	}

}
