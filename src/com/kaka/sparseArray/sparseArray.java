package com.kaka.sparseArray;

public class sparseArray {

	public static void main(String[] args) {
		//ԭʼ��ά���飬11*11
		//0��ʾû�����ӣ�1��ʾ���ӣ�2��ʾ����
		int chessArr[][] = new int[11][11];
		chessArr[1][2]=1;
		chessArr[2][3]=2;
		//���ԭʼ����
		System.out.println("ԭ���飺");
		for (int[] row:chessArr) {
			for (int data : row) {
				System.out.printf("%d\t",data);//��ʽ��ʮ������%d
			}
			System.out.println("\t");
		}
		
		//дΪϡ������
		int sum = 0;//�������Ӹ���
		for (int[] row:chessArr) {
			for (int data : row) {
				if(data!=0)
					sum ++;
			}
		}
		System.out.println("��"+sum+"������");
		//����ϡ������
		int count=0;
		int spareArr[][]=new int[sum+1][3];//sum+1�У�����
		spareArr[0][0]=11;
		spareArr[0][1]=11;
		spareArr[0][2]=sum;
		//��ϡ�����鸳ֵ
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
		System.out.println("ϡ�����飺");
		//����ϡ������
		for (int i = 0; i < spareArr.length; i++) {
			System.out.printf("%d\t%d\t%d\t\n",spareArr[i][0],spareArr[i][1],spareArr[i][2]);
		}
		
	}

}
