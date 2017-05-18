package com.llh.bczm.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class AutoNum implements Runnable{

	public static AtomicInteger num = new AtomicInteger(0);
	
	@Override
	public void run() {
		num.getAndIncrement();
		System.out.println(num);
	}

	public AtomicInteger getNum() {
		return num;
	}

	public void setNum(AtomicInteger num) {
		this.num = num;
	}

}
