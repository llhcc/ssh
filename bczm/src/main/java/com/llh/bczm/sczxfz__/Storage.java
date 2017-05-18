package com.llh.bczm.sczxfz__;

import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Storage {

	private LinkedBlockingQueue<Object> list = new LinkedBlockingQueue<Object>(100);
	
	
	private final static int MAX = 100; 
	
	public void product(int num){
		try {
			if((list.size()) == MAX){
				System.out.println("不能生产，,list:" + list.size());
			}
			for(int i=0; i < num; i++){
				list.put(new Object());
			}
			System.out.println("生产：" + num + ",list:" + list.size());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		}
	}
	
	public void customer(int num){
		try {
			if(list.size() ==0){
				System.out.println("不能消费，,list:" + list.size());
			}
			
			for(int i=0; i < num; i++){
				list.take();
			}
			System.out.println("消费：" + num + ",list:" + list.size());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		}
	}

	public LinkedBlockingQueue<Object> getList() {
		return list;
	}

	public void setList(LinkedBlockingQueue<Object> list) {
		this.list = list;
	}

	public static int getMax() {
		return MAX;
	}
	
	
}
