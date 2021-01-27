package com.kaka.linkedList;
/**
 * 单向循环链表解决约瑟夫问题
 * @author kakar
 *
 */
public class Josephu {

	public static void main(String[] args) {
		// 测试一把看看构建环形链表，和遍历是否ok
		CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
		circleSingleLinkedList.addBoy(25);//加入五个小孩节点
		//circleSingleLinkedList.showBoy();
		circleSingleLinkedList.countBoy(1, 2, 25);//预计结果2->4->5->3
	}

}

//创建一个环形的单向链表
class CircleSingleLinkedList{
	//创建一个first节点，当前没有编号
	private Boy first = null;
	//添加小孩节点，构建成一个环形的链表
	public void addBoy(int nums) {
		//nums做一个数据校验
		if(nums <1) {
			System.out.println("nums的值不正确");
		}
		Boy curBoy = null; //辅助指针，帮助构建环形链表
		//使用for来构建我们的环形链表
		for (int i = 1; i <= nums; i++) {
			//根据编号，创建小孩节点
			Boy boy = new Boy(i);
			//如果是第一个小孩
			if(i == 1) {
				first = boy;
				first.setNext(first);
				curBoy = first; //让curBoy指向第一个小孩
			}else {
				 curBoy.setNext(boy);
				 boy.setNext(first);
				 curBoy = boy;
			}
		}
	}
	
	//遍历当前的环形链表
	public void showBoy() {
		//判断链表是否为空
		if(first == null) {
			System.out.println("链表为空");
			return;
		}
		//因为first不能动，因此我们仍然使用一个辅助指针完成遍历
		Boy curBoy = first;
		while(true) {
			System.out.printf("小孩的编号%d\n",curBoy.getNo());
			if(curBoy.getNext() == first) {//说明已经遍历完毕
				break;
			}
			curBoy = curBoy.getNext();//curboy后移
		}
	}
	
	/**
	 * 使用之前需要生成长度为nums的单向循环链表
	 * @param startNo 开始计数的位置
	 * @param countNum	数到第k个开始出圈
	 * @param nums	有n个数据
	 */
	public void countBoy(int startNo,int countNum,int nums){
		//先对数据进行校验
		if(first == null || startNo < 1 || startNo >nums) {//不规则的参数首先进行排除
			System.out.println("参数输入有误，请重新输入");
			return;
		}
		//创建要给辅助指针，帮助小孩出列
		Boy helper = first;
		//1.创建一个辅助指针（变量）helper，事先应该指向环形链表的最后这个界节点
		while(true) {
			if(helper.getNext() == first) {//helper已经指向了最后一个节点（实现了helper在first节点前一个，便于删除）
				break;
			}
			helper = helper.getNext();//helper后移
		}
		//2.helper和first移动startNo-1次，到达开始计数的点位（从2号开始数就移动2-1次）
		for(int i = 0;i < startNo-1;i++) {
			helper = helper.getNext();
			first = first.getNext();
		}
		//3.开始根据点位进行删除，数到countNum就删除，重新开始数，直到留下最后一个helper.getNext()=helper
		while(true) {
			if(helper.getNext() == helper) {//只剩最后一个
				break;
			}
			for(int i = 0;i < countNum-1;i++) {//first到达要删除的节点
				helper = helper.getNext();
				first = first.getNext();
			}
			System.out.printf("删除节点%d\n",first.getNo());
			//删除first指向的节点
			first = first.getNext();
			helper.setNext(first);
		}
		//4.剩下最后一个进行输出
		System.out.printf("删除节点%d\n",first.getNo());
	}
}

//创建一个Boy类，表示一个节点
class Boy {
	private int no; //编号
	private Boy next;
	Boy(int no) {
		this.no = no;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Boy getNext() {
		return next;
	}
	public void setNext(Boy next) {
		this.next = next;
	}
	
}
