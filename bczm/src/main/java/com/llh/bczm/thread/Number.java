package com.llh.bczm.thread;

public class Number implements  Runnable {
	
	public static volatile int num = 0;

	@Override
	public void run() {
		num++;
		System.out.println(num);
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	
	
}
