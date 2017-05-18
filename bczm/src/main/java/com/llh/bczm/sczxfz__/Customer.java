package com.llh.bczm.sczxfz__;

public class Customer extends Thread{

	private Storage storage;
	
	private int num;
	
	public Customer(Storage storage) {
		this.storage = storage;
	}

	@Override
	public void run(){
		customer(num);
	}
	
	public void customer(int num){
		storage.customer(num);
	}

	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
}
