package com.sunxin.producer.consumer;

public class Consumer extends Thread {

	Queue q;
	
	public Consumer(Queue q) {
		super();
		this.q = q;
	}

	@Override
	public void run() {
		
		while(true){
			System.out.println("Consumer get:"+q.getValue());
		}
	}
}
