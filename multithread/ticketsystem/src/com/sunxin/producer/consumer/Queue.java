package com.sunxin.producer.consumer;

public class Queue {
	int value;
	boolean bFull=false;

	public synchronized void setValue(int value) {
		if(!bFull){
			this.value = value;
			bFull=true;
			System.out.println("放值 invoke notify() 开始");
			notify();
			System.out.println("放值 invoke notify() 结束");
		}
		try {
			System.out.println("放值 invoke wait() 开始");
			wait();
			System.out.println("放值 invoke wait() 结束");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public synchronized  int getValue() {
		if(!bFull){
			try {
				System.out.println("取值 invoke wait() 开始");
				wait();
				System.out.println("取值 invoke wait() 结束");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("取值 invoke notify() 开始");
		notify();
		System.out.println("取值 invoke notify() 结束");
		bFull=false;
		return value;
	}
	
}
