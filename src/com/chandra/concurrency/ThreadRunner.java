package com.chandra.concurrency;
import java.util.Timer;


public class ThreadRunner {

	public static void main(String[] args) {
		
	runSomething();
	System.out.println("this is simple line");

	}
	
	public static void runSomething(){
		new Thread( new Runnable() {
		    @Override
		    public void run() {
		    	
					Timer timer = new Timer();
					timer.schedule(new Task(), 1000);
					try {
						Thread.sleep(10000);
						System.out.println("Running in Thread");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
		    }
		}).start();

	}

}
