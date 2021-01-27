package com.kaka.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolanNotation {

	public static void main(String[] args) {
		// �ȶ����沨�����ʽ
		//(3+4)*5-6 =>3 4 + 5 * 6 -
		String suffixExpression = "3 4 + 5 * 6 -";
		//˼·
		//1.�Ƚ�"3 4 + 5 * 6 -" =>�ŵ�ArrayList��
		//2.��ArrayList ���ݸ�һ�����������ջ��ɼ���
		List<String> rpnList = getListString(suffixExpression);
		//System.out.println(rpnList);
		int res = calculate(rpnList);
		System.out.println("����Ľ���ǣ�"+res);
	}
	
	//��һ���沨�����ʽ�����ν����ݺ���������뵽ArrayList��
	public static List<String> getListString(String suffixExpression){
		//��suffixExpression�ָ�
		String[] split = suffixExpression.split(" ");
		List<String> list = new ArrayList<String>();
		for (String item : split) {
			list.add(item);
		}
		return list;
	}
	
	//��ɶ��沨�����ʽ������
	public static int calculate(List<String> list) {
		//������ջ��ֻ��Ҫһ��ջ����
		Stack<String> stack = new Stack<String>();
		//����ls
		for (String item : list) {
			//����ʹ��������ʽ��ȡ����
			if(item.matches("\\d+")) {//ƥ����Ƕ�λ��
				//��ջ
				stack.push(item);
			}else {
				//pop���������������㣬����ջ
				int num2 = Integer.parseInt(stack.pop());
				int num1 = Integer.parseInt(stack.pop());
				int res = 0;
				if(item.equals("+")) {
					res = num1 + num2;
				}else if (item.equals("-")) {
					res = num1 - num2;
				}else if (item.equals("*")) {
					res = num1 * num2;
				}else if (item.equals("/")) {
					res = num1 / num2;
				}else {
					throw new RuntimeException("���������");
				}
				//��res��ջ
				stack.push(""+res);
			}
		}
		//�������stack�е�������������
		return Integer.parseInt(stack.pop());
	}

}
