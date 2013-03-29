package com.thread.test;

import java.util.Date;

import org.apache.log4j.Logger;

import junit.framework.TestCase;

public class Client1 extends TestCase {
	public static Date beginDate=new Date();
	public static Date endDate=null;
	static Logger logger=Logger.getLogger(Client1.class);
	
	public static void main(String[] args) {
		logger.warn("helloworld");
		MoneyStorage ms1=new MoneyStorage();
		MoneyStorage ms2=new MoneyStorage();
		Clerk clerk1=new Clerk(ms1);
		Clerk clerk2=new Clerk(ms2);
		Thread cleark1=new Thread(clerk1);
		Thread cleark2=new Thread(clerk2);
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
