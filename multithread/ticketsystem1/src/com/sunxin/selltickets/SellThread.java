package com.sunxin.selltickets;

public class SellThread implements Runnable {

	int tickets=100;
	Object o=new Object();
	public void run() {
		while(true){
			synchronized (o) {
				if(tickets>0){
//					try {
//						//System.out.println(Thread.currentThread().getName()+"睡眠开始!");
//						//Thread.sleep(10);
//						//System.out.println(Thread.currentThread().getName()+"睡眠结束!");
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
					System.out.println("当前售票点是:"+Thread.currentThread().getName()+
							",当前票号是:"+tickets);
					tickets--;
				}
			}
		}
	}

}
