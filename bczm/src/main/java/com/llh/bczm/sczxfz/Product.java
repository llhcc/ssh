package com.llh.bczm.sczxfz;

public class Product extends Thread{

	private Storage storage;
	
	private int num;
	
	public Product(Storage storage) {
		this.storage = storage;
	}
	
	@Override
	public void run() {
		product(num);
	}

	public void product(int num){
		storage.product(num);
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
