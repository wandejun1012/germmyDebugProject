package com.sunxin.producer.consumer;



/**
 * 
 * ͨ������������ǿ��Կ�������Producer��wait��ס�����Լ���Զ����Ȳ����Լ�
 * Ψ���ٿ�һ���̲߳��ܽ������ѡ���
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
			//System.out.println("��ֵ invoke notify() ��ʼ");
			notify();
			System.out.println("������notify����");
		}
		try {
			System.out.println("������wait��ʼ");
			wait();
			System.out.println("������wait����");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public synchronized  int getValue() {
		if(!bFull){
			try {
				//System.out.println("ȡֵ invoke wait() ��ʼ");
				wait();
				System.out.println("������wait����");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//System.out.println("ȡֵ invoke notify() ��ʼ");
		notify();
		System.out.println("������notify����");
		bFull=false;
		return value;
	}
	
}
