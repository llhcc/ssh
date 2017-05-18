package com.llh.bczm;

public class QuickSort {

	public static void main(String[] args) {
		int num[] = {3,4,2,7,8,1,1};
		quickSort(num,0,num.length-1);
		
		for(int i=0; i < num.length;i++){
			System.out.print(num[i] + " ");
		}
	}
	
	static void quickSort(int num[],int start,int end){
		if(start < end){
			int mid = getMid(num,start,end);
			quickSort(num,start,mid-1);
			quickSort(num,mid+1,end);
		}
	}
	
	static int getMid(int num[],int start,int end){
		int mid = 0;
		int startNum = num[start];
		while(start < end){
			while(num[end] >= startNum && start < end){
				//
				end--;
			}
			num[start] = num[end];
			while(num[start] < startNum && start < end){
				//
				start++;
			}
			num[end] = num[start];
		}
		num[start] = startNum;
		mid = start;
		return mid;
	}

}
