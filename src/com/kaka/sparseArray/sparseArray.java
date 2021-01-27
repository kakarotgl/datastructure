package com.kaka.sparseArray;

public class sparseArray {

	public static void main(String[] args) {
		//原始二维数组，11*11
		//0表示没有棋子，1表示红子，2表示蓝子
		int chessArr[][] = new int[11][11];
		chessArr[1][2]=1;
		chessArr[2][3]=2;
		//输出原始数组
		System.out.println("原数组：");
		for (int[] row:chessArr) {
			for (int data : row) {
				System.out.printf("%d\t",data);//格式化十进制数%d
			}
			System.out.println("\t");
		}
		
		//写为稀疏数组
		int sum = 0;//定义棋子个数
		for (int[] row:chessArr) {
			for (int data : row) {
				if(data!=0)
					sum ++;
			}
		}
		System.out.println("有"+sum+"个棋子");
		//定义稀疏数组
		int count=0;
		int spareArr[][]=new int[sum+1][3];//sum+1行，三列
		spareArr[0][0]=11;
		spareArr[0][1]=11;
		spareArr[0][2]=sum;
		//给稀疏数组赋值
		for (int i = 0; i < chessArr.length; i++) {
			for (int j = 0; j < chessArr[i].length; j++) {
				if(chessArr[i][j]!=0) {
					count++;
					spareArr[count][0]=i;
					spareArr[count][1]=j;
					spareArr[count][2]=chessArr[i][j];
				} 
			}
		}
		System.out.println("稀疏数组：");
		//遍历稀疏数组
		for (int i = 0; i < spareArr.length; i++) {
			System.out.printf("%d\t%d\t%d\t\n",spareArr[i][0],spareArr[i][1],spareArr[i][2]);
		}
		
	}

}
