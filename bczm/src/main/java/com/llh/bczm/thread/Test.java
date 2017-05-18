package com.llh.bczm.thread;

public class Test {

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		Thread t = new Thread(new Runnable(){
			@Override
			public void run() {
				for(int i=0; i< 30000;i++){
					Thread thread = new Thread(new Number());
					thread.start();
					/*try {
						thread.join();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}*/
				}
			}
		});
		
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//Thread.
		long end = System.currentTimeMillis();
		System.out.println("num=" + Number.num + ", time=" + (end-start));
	}

}
