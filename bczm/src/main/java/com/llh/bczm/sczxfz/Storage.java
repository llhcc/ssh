package com.llh.bczm.sczxfz;

import java.util.LinkedList;

public class Storage {

	private LinkedList<Object> list = new LinkedList<Object>();
	
	private final static int MAX = 100; 
	
	public void product(int num){
		synchronized(list){
			while((num + list.size()) > MAX){
				try {
					list.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			for(int i=0; i < num; i++){
				list.add(new Object());
			}
			System.out.println("生产：" + num + ",list:" + list.size());
			list.notifyAll();
		}
	}
	
	public void customer(int num){
		synchronized(list){
			while(num > list.size()){
				try {
					list.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			for(int i=0; i < num; i++){
				list.remove();
			}
			System.out.println("消费：" + num + ",list:" + list.size());
			list.notifyAll();
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
