package com.kaka.stack;

public class Calculator {

	public static void main(String[] args) {
		//根据前面的思路，完成表达式的运输
		String expression = "75+2*6-2";
		//创建两个栈，数栈，一个符号栈
		ArrayStack2 numStack2 = new ArrayStack2(10);
		ArrayStack2 operStack2 = new ArrayStack2(10);
		
		//定义需要的相关变量
		int index = 0;//用于扫描
		int num1 = 0;
		int num2 = 0;
		int oper = 0;
		int res = 0;
		char ch = ' ';//将每次扫描得到char保存到ch
		String keepNum = ""; //用于拼接多位数
		//开始whille循环的扫描expression
		while(true) {
			//依次得到expression的每一个字符
			ch = expression.substring(index,index+1).charAt(0);
			//判断ch是什么，然后做相应的处理
			if (operStack2.isOper(ch)) {//如果是运算符
				//判断当前的符号栈是否为空
				if (!operStack2.isEmpty()) {//符号栈不为空，优先级判断
					//如果当前符号优先级小于等于栈中操作符，取出数栈两个数以及符号栈一个符号进行计算
					if (operStack2.priority(ch) <= operStack2.priority(operStack2.peek())) {
						num1 = numStack2.pop();
						num2 = numStack2.pop();
						oper = operStack2.pop();
						res = numStack2.cal(num1, num2, oper);
						//把运算的结果如数栈
						numStack2.push(res);
						//然后把当前的操作符入符号栈
						operStack2.push(ch);
					}else {
						//如果当前的操作符的优先级大于栈中的操作符，就直接入符号栈
						operStack2.push(ch);
					}
				}else {
					//如果为空直接入符号栈。。
					operStack2.push(ch);
				}
			}else {//如果是单数字，字符'3'的ascii是数字51，'2'是50，所以需要进行减去48，然后存入数栈
				//numStack2.push(ch - 48);
				
				//处理多位数
				//1.当处理多位数是，不能发现一个数字就立即入栈
				//2.在处理数，需要向expression的表达式的index后再看一位，如果是数就进行扫描，如果是符号才入栈
				//因此我们需要定义一个变量字符串，用于拼接
				
				keepNum +=ch;
				
				//判断下一个字符是不是数字，如果是数字，就继续扫描，如果是运算符，则入栈
				//注意看是不是最后一位，不是index++
				
				if(index == expression.length()-1) {
					numStack2.push(Integer.parseInt(keepNum));
				}else {
					if (operStack2.isOper(expression.substring(index+1,index+2).charAt(0))) {
						//如果后一位是运算符，则入栈keepNum = "1" 或者 "123"
						numStack2.push(Integer.parseInt(keepNum));
						//重要，keepNum清空
						keepNum = "";
					}
				}
			}
			//让index+1,并判断是否扫描到expression最后
			index++;
			if (index >= expression.length()) {
				break;
			}
		}
		
		//当表达式扫描完毕，就顺序的从数栈和符号栈中pop出相应的数和符号，并允行。
		while (true) {
			if (operStack2.isEmpty()) {//把符号栈所有符号取出后则计算完毕
				break;
			}
			num1 = numStack2.pop();
			num2 = numStack2.pop();
			oper = operStack2.pop();
			res = numStack2.cal(num1, num2, oper);
			//把运算的结果入数栈
			numStack2.push(res);
		}
		//将数栈的最后数，pop出，就是结果
		System.out.printf("表达式%s=%d",expression,numStack2.pop());
	}
}

//定义一个ArrayStack2表示栈,需要扩展功能
class ArrayStack2{
	private int maxSize;//表示栈的大小
	private int[] stack; //数组，数组模拟栈，数据就放在该数组
	private int top = -1; //top表示栈顶，初始化为-1
	
	//构造器
	public ArrayStack2(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[this.maxSize];
	}
	
	//增加一个方法，可以返回当前栈顶的值，但是不是真正的
	public int peek() {
		return stack[top];
	}
	
	//栈满
	public boolean isFull() {
		return top == maxSize-1;
	}
	
	//栈空
	public boolean isEmpty() {
		return top == -1;
	}
	
	//入栈
	public void push(int value) {
		//先判断栈是否满
		if(isFull()) {
			System.out.println("栈满");
			return;
		}
		top++;
		stack[top] = value;
	}
	
	//出栈-pop,将栈顶的数据返回
	public int pop() {
		//先判断栈是否空
		if(isEmpty()) {
			throw new RuntimeException("栈空，没有数据~");
		}
		int value = stack[top];
		top--;
		return value;
	}
	//显示栈的情况【遍历栈】，遍历时，需要从栈顶开始显示数据
	public void list() {
		if(isEmpty()) {
			System.out.println("栈空，没有数据");
		}
		//需要从栈顶开始显示数据
		for (int i = top; i >= 0; i--) {
			System.out.printf("stack[%d]=%d\n",i,stack[i]);
		}
	}
	
	//返回运算符的优先级，优先级是程序员来确定的，优先级使用数字表示
	//数字越大，则优先级越高
	public int priority(int oper) {
		if(oper == '*' || oper == '/') {
			return 1;
		}else if(oper == '+' || oper == '-'){
			return 0;
		}else {
			return -1;//假定目前的表达式只有+,-,*,/
		}
	}
	
	//判断是不是一个运算符
	public boolean isOper(char oper) {
		return oper == '+' || oper == '/' || oper == '*' || oper == '-';
	}
	
	//计算方法
	public int cal(int num1,int num2,int oper) {
		int res = 0;//res 用于存放计算的结果
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
