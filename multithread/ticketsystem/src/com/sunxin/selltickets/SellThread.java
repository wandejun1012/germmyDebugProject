package com.sunxin.selltickets;

public class SellThread implements Runnable {

	int tickets=100;
	Object o=new Object();
	public void run() {
		while(true){
			synchronized (o) {
				if(tickets>0){
//					try {
//						//System.out.println(Thread.currentThread().getName()+"˯�߿�ʼ!");
//						//Thread.sleep(10);
//						//System.out.println(Thread.currentThread().getName()+"˯�߽���!");
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
					System.out.println("��ǰ��Ʊ����:"+Thread.currentThread().getName()+
							",��ǰƱ����:"+tickets);
					tickets--;
				}
			}
		}
	}

}
