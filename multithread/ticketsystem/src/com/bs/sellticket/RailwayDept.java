package com.bs.sellticket;


/**
 * 铁道部，它可以卖票
 * @author Administrator
 *
 */
public class RailwayDept extends Thread{
	static int ticketCounts=100;//一共100张票
		
	public  synchronized void sellTicket(){
		while(ticketCounts>0){
//			ticketCounts--;
			ticketCounts=ticketCounts-1;
			System.out.println("当前线程名称为:"+Thread.currentThread().getName()+",当前剩余票数为:"+ticketCounts);
		}
	}
	
	@Override
	public void run() {
		
		sellTicket();
	}
	
	
	public static void main(String args[]){
		Thread rd1=new RailwayDept();
		Thread rd2=new Thread(rd1);
		Thread rd3=new Thread(rd1);
		Thread rd4=new Thread(rd1);
		
		
		rd1.start();
		rd2.start();
		rd3.start();
		rd4.start();
	}
	
	
}
