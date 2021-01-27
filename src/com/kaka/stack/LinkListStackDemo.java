package com.kaka.stack;
/**
 * ʹ������ʵ��ջ����ջpush�ͳ�ջpop���ܣ���Ҫ��������top��ʾ���һ��Ԫ�ص�ǰһ��Ԫ�أ��������ɾ����
 * ��ջpush��������������һ��Ԫ��
 * ��ջpop��ɾ���������һ��Ԫ��
 * ջ�����޶�����ĳ���
 * ջ�գ�head.next == null
 * ����������������
 * @author kakar
 *
 */
public class LinkListStackDemo {

	public static void main(String[] args) {
		// ����
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

//����һ���������ʾһ��ջ
class LinkListStack{
	//��ʼ��һ��ͷ�ڵ�
	private Student head = new Student(-1);
	private Student top = head;
	private int maxSize;//�޶�����ĳ���
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

	//��ȡ������
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
	
	//�ж�ջ��
	public boolean isFull() {
		return len == maxSize;
	}
	
	//�ж�ջ��
	public boolean isEmpty() {
		return len == 0;
	}
	
	//���Ԫ��push(��ͷ�ڵ����)
	public void push(Student stu) {
		if(isFull()) {
			System.out.println("ջ��");
			return;
		}
		top = head;
		//����
		stu.setNext(top.getNext());
		top.setNext(stu);
		len++;//ջ��һ
	}
	
	//ɾ��Ԫ��pop
	public int pop() {
		if(isEmpty()) {
			System.out.println("ջ��");
			return -1;
		}
		top = head;
		int value = top.getNext().getNo();
		len--;
		//ɾ��
		top.setNext(top.getNext().getNext());
		return value;
	}
	
	//����
	public void list() {
		if(isEmpty()) {
			System.out.println("ջ��");
		}
		top = head;
		for(int i = 0; i < len; i++) {//����
			top = top.getNext();
			System.out.println(top.getNo());
		}
		
	}
	
}

//����һ��ѧ��Ԫ��
class Student{
	private int no;
	private Student next;
	//���캯��
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
