package com.chandra.concurrency;
import java.util.TimerTask;

public class Task extends TimerTask{

	@Override
	public void run() {
		System.out.println("Running TimerTask");
		this.cancel();
		
	}

}