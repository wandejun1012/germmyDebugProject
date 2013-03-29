package com.thread.test;

import java.util.Date;

import org.apache.log4j.Logger;


/**
 * ���еĹ�����Ա������ר����Ǯ
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
				logger.warn("Thread Name is :"+Thread.currentThread().getName()+", ��ʼ������:"+beginDate);
				logger.warn("Thread Name is :"+Thread.currentThread().getName()+", ����������:"+getEndDate());
				logger.warn("Thread Name is :"+Thread.currentThread().getName()+", ���ʱ��Ϊ:"+(getEndDate().getTime()-beginDate.getTime())/1000);
				isClose=true;
				//������ﲻ--�Ļ�����ô���ֵ����Զ����0�����һᱻ����߳����С�
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
