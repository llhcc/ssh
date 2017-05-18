package com.llh.bczm;

/**
 * 八皇后问题
 * @author lanlonghui
 *
 */
public class BHH {
	static int count = 0;
	public static void main(String[] args) {
		int bhh[][] = new int[8][8];
		for(int i=0;i < 8; i++){
			for(int j=0; j < 8; j++){
				bhh[i][j] = 0;
			}
		}
		for(int i=0; i < 8; i++){
			for(int j=0; j < 8; j++){
				System.out.print(bhh[i][j] + " ");
			}
			System.out.println();
		}
		//for(int i=0 ;i < 8; i++){
			bhh(bhh,0);
		//}
		
		System.out.println("count总数：" + count);
	}
	
	static void bhh(int bhh[][],int x){
		int bhh_[][] = bhh.clone();
		if(x == 8){
			count++;
			System.out.println("count：" + count);
			for(int i=0; i < 8; i++){
				for(int j=0; j < 8; j++){
					System.out.print(bhh[i][j] + " ");
				}
				System.out.println();
			}
			//return;
		}else{
			for(int i=0;i< 8;i++){
				for(int j=0;j<8;j++)
					bhh_[x][j]=0;
				bhh_[x][i] = 1;
				if(check(bhh_,x,i)){
						bhh(bhh_,x+1);
				}
			}
		}
	}
	
	private static boolean isSafety(int[][] chess,int row,int col) {
        //判断中上、左上、右上是否安全
        int step=1;
        while(row-step>=0){
            if(chess[row-step][col]==1)                //中上
                return false;
            if(col-step>=0 && chess[row-step][col-step]==1)        //左上
                return false;
            if(col+step<8 && chess[row-step][col+step]==1)        //右上
                return false;
            
            step++;
        }
        return true;
    }
	
	static boolean check(int bhh[][],int x,int y){
		boolean flag=true,flag1=true,flag2=true,flag3=true,flag4=true,flag5=true;
		
		for(int i=0; i < 8;i++){
			if(i != y && bhh[i][y] == 1){
				flag = false;
			}
		}
		for(int i=0;i < 8;i++){
			if(i != x && bhh[x][i] ==1){
				flag1 = false;
			}
		}
		for(int i=x,j=y; i>=0 && j>=0;i--,j--){
			if(i != x && i != y && bhh[i][j] == 1){
				flag2 = false;
			}
		}
		for(int i=x,j=y; i<=7 && j<=7;i++,j++){
			if(i != x && i != y && bhh[i][j] == 1){
				flag3 = false;
			}
		}
		for(int i=x,j=y; i>=0 && j<=7;i--,j++){
			if(i != x && i != y && bhh[i][j] == 1){
				flag4 = false;
			}
		}
		for(int i=x,j=y; i<=7 && j>=0;i++,j--){
			if(i != x && i != y && bhh[i][j] == 1){
				flag5 = false;
			}
		}
		return flag && flag1 && flag2 && flag3 && flag4 && flag5;
	}

}
