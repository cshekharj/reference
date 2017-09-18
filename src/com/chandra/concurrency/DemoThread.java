package com.chandra.concurrency;

public class DemoThread implements Runnable{

	private String name =null;
	
	public DemoThread(String name) {
		this.name=name;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		try{
			Thread.sleep(1000);
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}
		System.out.println("Running : " + name);
	}
}
