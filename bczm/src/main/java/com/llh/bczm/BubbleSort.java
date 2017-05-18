package com.llh.bczm;

public class BubbleSort {

	public static void main(String[] args) {
		int num[] = {2,4,5,1,3,6,7,9,0};
		
		for(int i=0;i < num.length;i++){
			for(int j=i;j<num.length;j++){
				if(num[i] < num[j]){
					int temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}
		for(int i=0;i<num.length;i++){
			System.out.print(num[i] + " ");
		}
	}

}
