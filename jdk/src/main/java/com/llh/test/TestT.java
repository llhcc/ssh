package com.llh.test;

public class TestT {

	public static void main(String args[]){
		Thread.currentThread().interrupt();  
		System.out.println("Interrupted:"+ Thread.interrupted());  
	//  下面的判断会打印出来这样的语句 Interrupt：false  
	//  这样的结果是不是很让人费解呢？？？  
	//    
	//  分析其原因为：  
	//    
	//  因为在上面的一句代码可以中断线程，所以if判断线程是否中断就会得到的事true  
	//  但是 Thread.interrupted()这个方法执行完后就会清除线程的中断状态，  
	//  所以最后再次的打印Thread.interrupted()方法就会得到false结果。  
	if(Thread.interrupted())  
	System.out.println("Interrupted:"+ Thread.interrupted());  
	else  
	{  
	System.out.println("Not Interrupted"+Thread.interrupted());  
	}  
	//  如果用下面的这个方法来进行if判断就会出现那种情况了，  
	//  Thread.currentThread().isInterrupted();这个方法得到的结果：Interrupt：true  
	//    
	//  因为它判断完后就不会清除线程的中断状态，只是返回一个线程状态的结果  
	}  
}
