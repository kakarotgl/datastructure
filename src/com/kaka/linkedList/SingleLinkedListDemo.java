package com.kaka.linkedList;

public class SingleLinkedListDemo {
	public static void main(String[] args) {
		//进行测试
		//线创建节点
		HeroNode hero1 = new HeroNode(1, "松江", "及时雨");
		HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
		HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
		HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
		
		//创建链表
		SingleLinkedList singleLinkedList = new SingleLinkedList();
//		//顺序加入
//		singleLinkedList.add(hero1);
//		singleLinkedList.add(hero4);
//		singleLinkedList.add(hero3);
//		singleLinkedList.add(hero2);
		
		//按编号大小排序加入
		singleLinkedList.addByOrder(hero1);
		singleLinkedList.addByOrder(hero4);
		singleLinkedList.addByOrder(hero3);
		singleLinkedList.addByOrder(hero2);
		//singleLinkedList.addByOrder(hero4);
		
		//显示一把.修改前的数据
		System.out.println("修改前的数据");
		singleLinkedList.list();
		
		//测试修改节点的代码
		HeroNode newHeroNode = new HeroNode(2, "卢义", "麒麟");
		singleLinkedList.update(newHeroNode);
		
		System.out.println("修改后的数据");
		//显示一把，修改后的数据
		singleLinkedList.list();
		
		//删除一个节点
		singleLinkedList.del(1);
		singleLinkedList.del(2);
		singleLinkedList.del(3);
		singleLinkedList.del(4);
		singleLinkedList.del(5);
		System.out.println("删除后数据");
		singleLinkedList.list();
		
	}

}

//定义SingleLinkList管理我的的英雄
class SingleLinkedList{
	//先初始化一个头节点，头节点不要动
	private HeroNode head = new HeroNode(0,"","");
	
	//添加节点到单向链表
	//思路，当不考虑编号顺序时，
	//1.找到当前节点的最后节点
	//2.将最后这个节点的next指向新的节点
	public void add(HeroNode heroNode) {
		//因为head节点不能懂，因此我们需要一个辅助节点temp
		HeroNode temp = head;
		//遍历链表，找到最后
		while(true){
			//找到链表的最后
			if(temp.next==null) {
				break;
			}
			//如果没有找到最后，将temp后移
			temp = temp.next;
		}
		//当退出while循环时，temp就指向了链表的最后
		//这个节点的next，就指向新的节点
		temp.next=heroNode;
	}
	
	//显示链表[遍历]
	public void list() {
		//判断链表是否为空
		if(head.next==null) {
			System.out.println("链表为空");
			return;
		}
		//因为头节点，不能动，因此我们需要一个辅助变量来遍历
		HeroNode temp = head.next;
		while(true) {
			//输出节点的信息
			System.out.println(temp);
			if(temp.next == null) {
				break;
			}
			//移动到下一个
			temp=temp.next;
		}
	}
	//第二种方式再添加英雄时，根据排名将英雄插入到指定位置
		//（如果有这个排名，则添加失败，并给出提示）
		public void addByOrder(HeroNode heroNode) {
			//因为头节点不能懂，因此我们仍然通过一个辅助指针（变量）来帮助找到添加的位置
			//因为单链表，因为我们找的temp是位于添加位置的前一个节点否则插入不了
			HeroNode temp = head;
			boolean flag = false; //flag标志添加的编号是否存在，默认为false
			while (true) {
				if(temp.next == null) {//说明temp已经再链表的最后
					break;
				}
				if(temp.next.no > heroNode.no) {//说明temp已经在链表的最后
					break;
				}else if(temp.next.no == heroNode.no) {
					flag = true; //说明编号存在
				}
				temp = temp.next;//后移，遍历链表
			}
			//判断flag的值
			if(flag) {//不能添加，说明编号存在
				System.out.printf("准备插入的英雄编号%d已经存在了，不能加入\n",heroNode.no);
				
			}
			else {
				//插入到链表中，temp的后面
				heroNode.next =  temp.next;
				temp.next = heroNode;
			}
		}
		
		//修改节点的信息，根据no编号来修改，即no编号不能改
		//说明
		//1.根据newHeroNOde的no来修改即可
		public void update(HeroNode newHeroNode) {
			//判断是否为空
			if(head.next == null) {
				System.out.println("链表为空~");
				return;
			}
			//找到需要修改的节点，根据no编号
			//定义一个辅助变量
			HeroNode temp = head.next;
			boolean flag = false;//表示是否找到该节点
			while(true) {
				if(temp ==null) {
					//已经遍历完链表
				}
				if(temp.no == newHeroNode.no) {
					//找到
					flag=true;
					break;
				}
				temp = temp.next;
			}
			//根据flag 判断是否找到要修改的节点
			if(flag) {
				temp.name = newHeroNode.name;
				temp.nickname = newHeroNode.nickname;
			}else {
				System.out.printf("没有找到编号%d的节点，不能修改\n",newHeroNode.no);
			}
		}
		
		//删除节点
		//思路
		//1.head不能懂，因此我们需要一个temp辅助节点找到代删除节点的前一个节点
		//2.说明我们在比较是，是temp.next.no和需要删除节点的no比较
		public void del(int no) {
			HeroNode temp = head;
			boolean flag = false;//标志是否找到待删除节点
			while(true) {
				if(temp.next == null) {
					break;
				}
				if(temp.next.no == no) {//找到下一个节点是需要删除的节点
					flag=true;
					break;
				}
				temp = temp.next;//temp后移，遍历
			}
			//判断flag
			if(flag) {
				//可以删除
				temp.next = temp.next.next;
			}else {
				System.out.printf("要删除的%d节点不存在",no);
			}
			
		}
		
}

//定义HeroNode，每个HeroNode,对象就是一个节点
class HeroNode{
	public int no;
	public String name;
	public String nickname;
	public HeroNode next;//指向下一个节点
	
	//构造器
	public HeroNode(int no,String name,String nickname) {
		this.no=no;
		this.name= name;
		this.nickname=nickname;
	}
	
	

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
	
}
