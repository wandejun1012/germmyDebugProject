package com.sunxin.producer.consumer;

public class Queue {
	int value;
	boolean bFull=false;

	public synchronized void setValue(int value) {
		if(!bFull){
			this.value = value;
			bFull=true;
			System.out.println("��ֵ invoke notify() ��ʼ");
			notify();
			System.out.println("��ֵ invoke notify() ����");
		}
		try {
			System.out.println("��ֵ invoke wait() ��ʼ");
			wait();
			System.out.println("��ֵ invoke wait() ����");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public synchronized  int getValue() {
		if(!bFull){
			try {
				System.out.println("ȡֵ invoke wait() ��ʼ");
				wait();
				System.out.println("ȡֵ invoke wait() ����");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("ȡֵ invoke notify() ��ʼ");
		notify();
		System.out.println("ȡֵ invoke notify() ����");
		bFull=false;
		return value;
	}
	
}
