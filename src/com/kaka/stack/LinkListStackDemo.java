package com.kaka.stack;
/**
 * 使用链表实现栈的入栈push和出栈pop功能（需要辅助变量top表示最后一个元素的前一个元素，方便添加删除）
 * 入栈push：在链表最后添加一个元素
 * 出栈pop：删除链表最后一个元素
 * 栈满：限定链表的长度
 * 栈空：head.next == null
 * 遍历：遍历链表即可
 * @author kakar
 *
 */
public class LinkListStackDemo {

	public static void main(String[] args) {
		// 测试
		LinkListStack linkListStack = new LinkListStack(4);
		Student stu1 = new Student(10);
		Student stu2 = new Student(20);
		Student stu3 = new Student(30);
		Student stu4 = new Student(40);
		Student stu5 = new Student(50);
		
		linkListStack.push(stu1);
		linkListStack.push(stu2);
		linkListStack.push(stu3);
		linkListStack.push(stu4);
		linkListStack.push(stu5);
		
//		int p1 = linkListStack.pop();
//		System.out.println("p1:"+p1);
//		int p2 = linkListStack.pop();
//		System.out.println("p2:"+p2);
//		int p3 = linkListStack.pop();
//		System.out.println("p3:"+p3);
//		int p4 = linkListStack.pop();
//		System.out.println("p4:"+p4);
//		int p5 = linkListStack.pop();
//		System.out.println("p5:"+p5);
//		linkListStack.list();
	}

}

//定义一个单链表表示一个栈
class LinkListStack{
	//初始化一个头节点
	private Student head = new Student(-1);
	private Student top = head;
	private int maxSize;//限定链表的长度
	private int len = 0;
	public LinkListStack(int maxSize) {
		this.maxSize = maxSize;
	}
	
	public Student getHead() {
		return head;
	}

	public void setHead(Student head) {
		this.head = head;
	}

	public Student getTop() {
		return top;
	}

	public void setTop(Student top) {
		this.top = top;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	//获取链表长度
//	public int getLength() {
//		int count = 0;
//		while(true) {
//			if(top.getNext() == null) {
//				break;
//			}
//			top = top.getNext();
//			count++;
//		}
//		return count;
//	}
	
	//判断栈满
	public boolean isFull() {
		return len == maxSize;
	}
	
	//判断栈空
	public boolean isEmpty() {
		return len == 0;
	}
	
	//添加元素push(在头节点插入)
	public void push(Student stu) {
		if(isFull()) {
			System.out.println("栈满");
			return;
		}
		top = head;
		//插入
		stu.setNext(top.getNext());
		top.setNext(stu);
		len++;//栈加一
	}
	
	//删除元素pop
	public int pop() {
		if(isEmpty()) {
			System.out.println("栈空");
			return -1;
		}
		top = head;
		int value = top.getNext().getNo();
		len--;
		//删除
		top.setNext(top.getNext().getNext());
		return value;
	}
	
	//遍历
	public void list() {
		if(isEmpty()) {
			System.out.println("栈空");
		}
		top = head;
		for(int i = 0; i < len; i++) {//遍历
			top = top.getNext();
			System.out.println(top.getNo());
		}
		
	}
	
}

//定义一个学生元素
class Student{
	private int no;
	private Student next;
	//构造函数
	public Student(int no) {
		this.no = no;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Student getNext() {
		return next;
	}
	public void setNext(Student next) {
		this.next = next;
	}
	@Override
	public String toString() {
		return "Student [no=" + no + "]";
	}
	
}
