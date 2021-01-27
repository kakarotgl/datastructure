package com.kaka.stack;

public class Calculator {

	public static void main(String[] args) {
		//����ǰ���˼·����ɱ��ʽ������
		String expression = "75+2*6-2";
		//��������ջ����ջ��һ������ջ
		ArrayStack2 numStack2 = new ArrayStack2(10);
		ArrayStack2 operStack2 = new ArrayStack2(10);
		
		//������Ҫ����ر���
		int index = 0;//����ɨ��
		int num1 = 0;
		int num2 = 0;
		int oper = 0;
		int res = 0;
		char ch = ' ';//��ÿ��ɨ��õ�char���浽ch
		String keepNum = ""; //����ƴ�Ӷ�λ��
		//��ʼwhilleѭ����ɨ��expression
		while(true) {
			//���εõ�expression��ÿһ���ַ�
			ch = expression.substring(index,index+1).charAt(0);
			//�ж�ch��ʲô��Ȼ������Ӧ�Ĵ���
			if (operStack2.isOper(ch)) {//����������
				//�жϵ�ǰ�ķ���ջ�Ƿ�Ϊ��
				if (!operStack2.isEmpty()) {//����ջ��Ϊ�գ����ȼ��ж�
					//�����ǰ�������ȼ�С�ڵ���ջ�в�������ȡ����ջ�������Լ�����ջһ�����Ž��м���
					if (operStack2.priority(ch) <= operStack2.priority(operStack2.peek())) {
						num1 = numStack2.pop();
						num2 = numStack2.pop();
						oper = operStack2.pop();
						res = numStack2.cal(num1, num2, oper);
						//������Ľ������ջ
						numStack2.push(res);
						//Ȼ��ѵ�ǰ�Ĳ����������ջ
						operStack2.push(ch);
					}else {
						//�����ǰ�Ĳ����������ȼ�����ջ�еĲ���������ֱ�������ջ
						operStack2.push(ch);
					}
				}else {
					//���Ϊ��ֱ�������ջ����
					operStack2.push(ch);
				}
			}else {//����ǵ����֣��ַ�'3'��ascii������51��'2'��50��������Ҫ���м�ȥ48��Ȼ�������ջ
				//numStack2.push(ch - 48);
				
				//�����λ��
				//1.�������λ���ǣ����ܷ���һ�����־�������ջ
				//2.�ڴ���������Ҫ��expression�ı��ʽ��index���ٿ�һλ����������ͽ���ɨ�裬����Ƿ��Ų���ջ
				//���������Ҫ����һ�������ַ���������ƴ��
				
				keepNum +=ch;
				
				//�ж���һ���ַ��ǲ������֣���������֣��ͼ���ɨ�裬����������������ջ
				//ע�⿴�ǲ������һλ������index++
				
				if(index == expression.length()-1) {
					numStack2.push(Integer.parseInt(keepNum));
				}else {
					if (operStack2.isOper(expression.substring(index+1,index+2).charAt(0))) {
						//�����һλ�������������ջkeepNum = "1" ���� "123"
						numStack2.push(Integer.parseInt(keepNum));
						//��Ҫ��keepNum���
						keepNum = "";
					}
				}
			}
			//��index+1,���ж��Ƿ�ɨ�赽expression���
			index++;
			if (index >= expression.length()) {
				break;
			}
		}
		
		//�����ʽɨ����ϣ���˳��Ĵ���ջ�ͷ���ջ��pop����Ӧ�����ͷ��ţ������С�
		while (true) {
			if (operStack2.isEmpty()) {//�ѷ���ջ���з���ȡ������������
				break;
			}
			num1 = numStack2.pop();
			num2 = numStack2.pop();
			oper = operStack2.pop();
			res = numStack2.cal(num1, num2, oper);
			//������Ľ������ջ
			numStack2.push(res);
		}
		//����ջ���������pop�������ǽ��
		System.out.printf("���ʽ%s=%d",expression,numStack2.pop());
	}
}

//����һ��ArrayStack2��ʾջ,��Ҫ��չ����
class ArrayStack2{
	private int maxSize;//��ʾջ�Ĵ�С
	private int[] stack; //���飬����ģ��ջ�����ݾͷ��ڸ�����
	private int top = -1; //top��ʾջ������ʼ��Ϊ-1
	
	//������
	public ArrayStack2(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[this.maxSize];
	}
	
	//����һ�����������Է��ص�ǰջ����ֵ�����ǲ���������
	public int peek() {
		return stack[top];
	}
	
	//ջ��
	public boolean isFull() {
		return top == maxSize-1;
	}
	
	//ջ��
	public boolean isEmpty() {
		return top == -1;
	}
	
	//��ջ
	public void push(int value) {
		//���ж�ջ�Ƿ���
		if(isFull()) {
			System.out.println("ջ��");
			return;
		}
		top++;
		stack[top] = value;
	}
	
	//��ջ-pop,��ջ�������ݷ���
	public int pop() {
		//���ж�ջ�Ƿ��
		if(isEmpty()) {
			throw new RuntimeException("ջ�գ�û������~");
		}
		int value = stack[top];
		top--;
		return value;
	}
	//��ʾջ�����������ջ��������ʱ����Ҫ��ջ����ʼ��ʾ����
	public void list() {
		if(isEmpty()) {
			System.out.println("ջ�գ�û������");
		}
		//��Ҫ��ջ����ʼ��ʾ����
		for (int i = top; i >= 0; i--) {
			System.out.printf("stack[%d]=%d\n",i,stack[i]);
		}
	}
	
	//��������������ȼ������ȼ��ǳ���Ա��ȷ���ģ����ȼ�ʹ�����ֱ�ʾ
	//����Խ�������ȼ�Խ��
	public int priority(int oper) {
		if(oper == '*' || oper == '/') {
			return 1;
		}else if(oper == '+' || oper == '-'){
			return 0;
		}else {
			return -1;//�ٶ�Ŀǰ�ı��ʽֻ��+,-,*,/
		}
	}
	
	//�ж��ǲ���һ�������
	public boolean isOper(char oper) {
		return oper == '+' || oper == '/' || oper == '*' || oper == '-';
	}
	
	//���㷽��
	public int cal(int num1,int num2,int oper) {
		int res = 0;//res ���ڴ�ż���Ľ��
		switch (oper) {
		case '+':
			res = num1 + num2;
			break;
		case '-':
			res = num2 - num1;
			break;
		case '*':
			res = num1 * num2;
			break;
		case '/':
			res = num2 / num1;
			break;
		default:
			break;
		}
		return res;
	}
}
