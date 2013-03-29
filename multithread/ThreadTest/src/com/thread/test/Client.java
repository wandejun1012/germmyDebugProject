package com.thread.test;

import java.util.Date;

public class Client {
	
	public static Date beginDate=new Date();
	public static Date endDate=null;
	public static void main(String[] args) {
		//begin time
//		Date beginDate=new Date();
		//ms
		MoneyStorage ms=new MoneyStorage();
		Clerk clerk=new Clerk(ms);
		Thread cleark1=new Thread(clerk);
		Thread cleark2=new Thread(clerk);
		cleark1.start();
		cleark2.start();
		
	}
	public static Date getEndDate() {
		return endDate;
	}
	public static void setEndDate(Date endDate) {
		Client.endDate = endDate;
	}
}


