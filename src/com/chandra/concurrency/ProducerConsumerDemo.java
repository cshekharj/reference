package com.chandra.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerDemo {
	
	public static void main(String[] args) throws Exception{
		BlockingQueue<Object> queue = new LinkedBlockingQueue<>();
		Thread consumer = new Thread(new Consumer(queue));
		Thread producer = new Thread(new Producer(queue));
		
		consumer.start();
		producer.start();
		Thread.sleep(1000);
	}

}

class Consumer implements Runnable {
	
	private BlockingQueue<Object> queue ;

	public Consumer(BlockingQueue<Object> queue) {
		this.queue=queue;
	}

	@Override
	public void run() {
		for(int i=1;i<20;i++){
			System.out.println("Adding :-"+i);
			queue.add(i);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class Producer implements Runnable {	

	private BlockingQueue<Object> queue ;
	public Producer(BlockingQueue<Object> queue) {
		this.queue=queue;
	}

	@Override
	public void run() {
		try {
            while(true){
            	System.out.println("Taking "+queue.take());
            	Thread.sleep(2000);
            	if(queue.size() == 0)
            		break;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
