package com.bs.sellticket;


/**
 * ����������������Ʊ
 * @author Administrator
 *
 */
public class RailwayDept extends Thread{
	static int ticketCounts=100;//һ��100��Ʊ
		
	public  synchronized void sellTicket(){
		while(ticketCounts>0){
//			ticketCounts--;
			ticketCounts=ticketCounts-1;
			System.out.println("��ǰ�߳�����Ϊ:"+Thread.currentThread().getName()+",��ǰʣ��Ʊ��Ϊ:"+ticketCounts);
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
