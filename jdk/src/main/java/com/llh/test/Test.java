package com.llh.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;

public class Test<K,V> {

	static Map<String,String> map = new HashMap<String,String>();
	
	static final Entry<?,?>[] EMPTY_TABLE = {};
	
	String params;
	
	transient  Entry<K,V>[] table = (Entry<K,V>[]) EMPTY_TABLE;
	 
	public static void main(String[] args) {
		HashMap map = new HashMap();
		String s = "sss";
		String ss = "sss";
		System.out.println(s.equals(ss));
		Test test = new Test("77777");
		
		ArrayList list = new ArrayList();
		list.add("s");
		list.add(1);
		list.add(test);
		System.out.println(list.indexOf("s"));
		
		
		((Test)(list.get(2))).setParams("8888888888");
		ArrayList list1 = (ArrayList)list.clone();
		for(int i=0;i<list1.size();i++){
			System.out.println(list1.get(i));
		}
		System.out.println(((Test)(list1.get(2))).getParams());
		
		//2147483647
		System.out.println(Integer.MAX_VALUE);
		System.out.println((1 << 31) -1);
		System.out.println((1L << 63) -1);
		System.out.println(Long.MAX_VALUE);
		
		System.out.println("--------------------------");
		System.out.println(Character.MAX_VALUE);
		System.out.println(Character.MIN_VALUE);
		
		new LinkedList();
		new TreeMap();
		
		char c= 's';
		char cc = 's';
		System.out.println(c==cc);
		
		int N=10;
		
		 CountDownLatch doneSignal = new CountDownLatch(N);  
	        CountDownLatch startSignal = new CountDownLatch(1);//开始执行信号  
	  
	        for (int i = 1; i <= N; i++) {  
	            new Thread(new ThreadTest(i, doneSignal, startSignal)).start();//线程启动了  
	        }  
	        System.out.println("begin------------");  
	        startSignal.countDown();//开始执行啦  
	        try {
				doneSignal.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}//等待所有的线程执行完毕  
	        System.out.println("Ok");  
	        
	        System.out.println(Thread.currentThread().interrupted());
	        System.out.println(Thread.interrupted());
	        
	        
	        Thread t1 = new MyThread1();
            t1.start(); 

            for (int i = 0; i < 20; i++) {
                    System.out.println("主线程第" + i +"次执行！");
                    if (i > 2)try { 
                            //t1线程合并到主线程中，主线程停止执行过程，转而执行t1线程，直到t1执行完毕后继续。
                            t1.join(); 
                    } catch (InterruptedException e) {
                            e.printStackTrace(); 
                    } 
            } 
	}
	
	public Test(String params){
		this.params=params;
		if(table == EMPTY_TABLE){
			System.out.println("0000000");
		}
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}
	
	

}
