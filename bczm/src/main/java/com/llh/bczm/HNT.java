package com.llh.bczm;

/**
 * 汉诺塔
 * @author lanlonghui
 *
 */
public class HNT {

	public static void main(String[] args) {
		String x = "x";
		String y = "y";
		String z = "z";
		mov(2,x,y,z);
	}
	
	static void mov(int num,String x,String y,String z){
		if(num == 1){
			System.out.println(x + "-->" + z);
		}else{
			mov(num-1,x,z,y);
			System.out.println(x + "-->" + z);
			mov(num-1,y,x,z);
		}
	}

}
