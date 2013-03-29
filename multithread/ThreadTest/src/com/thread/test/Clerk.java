package com.thread.test;

import java.util.Date;

import org.apache.log4j.Logger;


/**
 * 银行的工作人员，它们专门数钱
 * @author Administrator
 *
 */
public class Clerk implements Runnable {
	MoneyStorage ms;
	Date beginDate=new Date();
	Date endDate=null;
	boolean isClose=false;
	Logger logger=Logger.getLogger(Clerk.class);
	public Clerk(MoneyStorage ms) {
		super();
		this.ms = ms;
	}

	private  synchronized void countMoney(){
		if(this.ms.moneyNumber>0){
			System.out.println("Thread Name is :"+Thread.currentThread().getName()+", Current Money is "+this.ms.moneyNumber);
			this.ms.moneyNumber--;
		}else if(this.ms.moneyNumber==0){
				setEndDate(new Date());
				logger.warn("Thread Name is :"+Thread.currentThread().getName()+", 开始日期是:"+beginDate);
				logger.warn("Thread Name is :"+Thread.currentThread().getName()+", 结束日期是:"+getEndDate());
				logger.warn("Thread Name is :"+Thread.currentThread().getName()+", 相隔时间为:"+(getEndDate().getTime()-beginDate.getTime())/1000);
				isClose=true;
				//如果这里不--的话，那么这个值将永远都是0，而且会被多个线程运行。
				this.ms.moneyNumber--;
			}
		}

	public void run() {
		while(!isClose){
			countMoney();
		}
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
