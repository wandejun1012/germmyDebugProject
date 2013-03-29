package com.sunxin.producer.consumer;

public class Producer extends Thread {

	Queue q;
	public Producer(Queue q) {
		super();
		this.q = q;
	}
	@Override
	public void run() {
		for(int i=0;i<10;i++){
			q.setValue(i);
			System.out.println("Producer produces:"+i);
		}
	}
	
}
