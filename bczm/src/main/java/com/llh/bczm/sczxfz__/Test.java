package com.llh.bczm.sczxfz__;

public class Test {

	public static void main(String[] args) {
		Storage storage = new Storage();
		// 生产者对象  
        Product p1 = new Product(storage);  
        Product p2 = new Product(storage);  
        Product p3 = new Product(storage);  
        Product p4 = new Product(storage);  
        Product p5 = new Product(storage);  
        Product p6 = new Product(storage);  
        Product p7 = new Product(storage);  
  
        // 消费者对象  
        Customer c1 = new Customer(storage);  
        Customer c2 = new Customer(storage);  
        Customer c3 = new Customer(storage);  
  
        // 设置生产者产品生产数量  
        p1.setNum(10);  
        p2.setNum(10);  
        p3.setNum(10);  
        p4.setNum(10);  
        p5.setNum(10);  
        p6.setNum(10);  
        p7.setNum(80);  
  
        // 设置消费者产品消费数量  
        c1.setNum(50);  
        c2.setNum(20);  
        c3.setNum(30);  
  
        // 线程开始执行  
        c1.start();  
        c2.start();  
        c3.start();  
        p1.start();  
        p2.start();  
        p3.start();  
        p4.start();  
        p5.start();  
        p6.start();  
        p7.start();  
	}

}
