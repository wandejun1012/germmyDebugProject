package com.sunxin.selltickets;

public class SellTickets {
	public static void main(String[] args) {
		SellThread st=new SellThread();
		new Thread(st).start();
		new Thread(st).start();
		new Thread(st).start();
		new Thread(st).start();
	}
}
