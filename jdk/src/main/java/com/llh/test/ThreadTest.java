package com.llh.test;

import java.util.concurrent.CountDownLatch;

public class ThreadTest implements Runnable{

	private final CountDownLatch doneSignal;  
    private final CountDownLatch startSignal;  
    private int beginIndex;  

    ThreadTest(int beginIndex, CountDownLatch doneSignal,  
            CountDownLatch startSignal) {  
        this.startSignal = startSignal;  
        this.beginIndex = beginIndex;  
        this.doneSignal = doneSignal;  
    }
        
	public void run() {
		try {  
            startSignal.await(); //等待开始执行信号的发布  
            beginIndex = (beginIndex - 1) * 10 + 1;  
            for (int i = beginIndex; i < beginIndex + 10; i++) {  
                System.out.println(i);  
            }  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        } finally {  
            doneSignal.countDown();  
            System.out.println("count======="+doneSignal.getCount());
        }  
	}

}
