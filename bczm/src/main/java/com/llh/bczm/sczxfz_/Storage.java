package com.llh.bczm.sczxfz_;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Storage {

	private LinkedList<Object> list = new LinkedList<Object>();
	
	private final Lock lock = new ReentrantLock();
	
	
	private final static int MAX = 100; 
	
	private final Condition full = lock.newCondition();
	
	private final Condition empty = lock.newCondition();
	
	public void product(int num){
		lock.lock();
		try {
			while((num + list.size()) > MAX){
				System.out.println("不能生产，,list:" + list.size());
				try {
					full.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			for(int i=0; i < num; i++){
				list.add(new Object());
			}
			System.out.println("生产：" + num + ",list:" + list.size());
			//if(list.size() >)
			full.signalAll();
			empty.signalAll();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	
	public void customer(int num){
		lock.lock();
		try {
			while(num > list.size()){
				System.out.println("不能消费，,list:" + list.size());
				try {
					empty.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			for(int i=0; i < num; i++){
				list.remove();
			}
			System.out.println("消费：" + num + ",list:" + list.size());
			full.signalAll();
			empty.signalAll();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}

	public LinkedList<Object> getList() {
		return list;
	}

	public void setList(LinkedList<Object> list) {
		this.list = list;
	}

	public static int getMax() {
		return MAX;
	}
	
	
}
