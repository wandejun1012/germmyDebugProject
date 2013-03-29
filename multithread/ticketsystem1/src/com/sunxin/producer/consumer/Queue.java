package com.sunxin.producer.consumer;



/**
 * 
 * 通过这个类子我们可以看出，当Producer被wait困住后，它自己永远都解救不了自己
 * 唯有再开一个线程才能将它唤醒。。
 * @author Administrator
 *
 */

public class Queue {
	int value;
	boolean bFull=false;

	public synchronized void setValue(int value) {
		if(!bFull){
			this.value = value;
			bFull=true;
			//System.out.println("放值 invoke notify() 开始");
			notify();
			System.out.println("生产者notify结束");
		}
		try {
			System.out.println("生产者wait开始");
			wait();
			System.out.println("生产者wait结束");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public synchronized  int getValue() {
		if(!bFull){
			try {
				//System.out.println("取值 invoke wait() 开始");
				wait();
				System.out.println("消费者wait结束");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//System.out.println("取值 invoke notify() 开始");
		notify();
		System.out.println("消费者notify结束");
		bFull=false;
		return value;
	}
	
}
