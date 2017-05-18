package com.llh.bczm.lhc;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<Integer> num33 = new ArrayList<Integer>();
		for(int i=0;i<33;i++){
			num33.add(i+1);
		}
		List<Integer> num16 = new ArrayList<Integer>();
		for(int i=0;i<16;i++){
			num16.add(i+1);
		}
		System.out.println("num33:" + num33);
		System.out.println("num16:" + num16);
		DecimalFormat format = new DecimalFormat("##");
		System.out.println("random33:" + format.format(new Double(Math.random() * (33-1) + 1)));
		System.out.println("random16:" + format.format(new Double(Math.random() * (16-1) + 1)));
		
		SimpleDateFormat df = new SimpleDateFormat("");
		Calendar c = Calendar.getInstance();
		//c.
		int year = Calendar.YEAR;
		int month = Calendar.MONTH;
		int day = Calendar.DAY_OF_MONTH;
		
		
	}

}
