package com.llh.bczm.single;

public class Singleton {

	private static volatile Singleton singleton;
	
	private Singleton(){
	}
	
	public static Singleton getSingleton(){
		if(null == singleton){
			synchronized(Singleton.class){
				if(null == singleton){
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}
	
}
