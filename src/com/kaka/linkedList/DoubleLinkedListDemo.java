package com.kaka.linkedList;

public class DoubleLinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("双向链表得测试");
		//先创建节点
		HeroNode2 hero1 = new HeroNode2(1, "松江", "及时雨");
		HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
		HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
		HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
		
		//创建一个双链表
		DoubleLinkList doubleLinkList = new DoubleLinkList();
		doubleLinkList.add(hero1);
		doubleLinkList.add(hero2);
		doubleLinkList.add(hero3);
		doubleLinkList.add(hero4);
		
		doubleLinkList.list();
		
		//修改
		HeroNode2 hero5 = new HeroNode2(4, "小林", "小包子");
		doubleLinkList.update(hero5);
		System.out.println("修改后数据");
		doubleLinkList.list();
		
		//删除
		doubleLinkList.del(3);
		System.out.println("删除后数据");
		doubleLinkList.list();
	}

}
class DoubleLinkList{
	//先初始化一个头节点，头节点不要动，不存放具体的数据
	private HeroNode2 head = new HeroNode2(0, "", "");
	
	//返回头节点
	public HeroNode2 getHead() {
		return head;
	}
	
	//显示链表[遍历]
		public void list() {
			//判断链表是否为空
			if(head.next==null) {
				System.out.println("链表为空");
				return;
			}
			//因为头节点，不能动，因此我们需要一个辅助变量来遍历
			HeroNode2 temp = head.next;
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
		//双向链表添加
		public void add(HeroNode2 heroNode2) {
			//因为head节点不能懂，因此我们需要一个辅助节点temp
			HeroNode2 temp = head;
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
			temp.next=heroNode2;
			heroNode2.pre = temp;
		}
	
		public void update(HeroNode2 newHeroNode2) {
			//判断是否为空
			if(head.next == null) {
				System.out.println("链表为空~");
				return;
			}
			//找到需要修改的节点，根据no编号
			//定义一个辅助变量
			HeroNode2 temp = head.next;
			boolean flag = false;//表示是否找到该节点
			while(true) {
				if(temp ==null) {
					//已经遍历完链表
				}
				if(temp.no == newHeroNode2.no) {
					//找到
					flag=true;
					break;
				}
				temp = temp.next;
			}
			//根据flag 判断是否找到要修改的节点
			if(flag) {
				temp.name = newHeroNode2.name;
				temp.nickname = newHeroNode2.nickname;
			}else {
				System.out.printf("没有找到编号%d的节点，不能修改\n",newHeroNode2.no);
			}
		}
		public void del(int no) {
			HeroNode2 temp = head;
			boolean flag = false;//标志是否找到待删除节点
			while(true) {
				if(temp == null) {
					break;
				}
				if(temp.no == no) {//找到下一个节点是需要删除的节点
					flag=true;
					break;
				}
				temp = temp.next;//temp后移，遍历
			}
			//判断flag
			if(flag) {
				//可以删除
				temp.pre.next = temp.next;
				if(temp.next != null) {//如果当前节点得下一个节点不为空
					temp.pre = temp.next.pre;
				}
			}else {
				System.out.printf("要删除的%d节点不存在",no);
			}
			
		}
		
}

//定义HeroNode，每个HeroNode,对象就是一个节点
class HeroNode2{
	public int no;
	public String name;
	public String nickname;
	public HeroNode2 next;//指向下一个节点
	public HeroNode2 pre; //指向前一个节点
	
	//构造器
	public HeroNode2(int no,String name,String nickname) {
		this.no=no;
		this.name= name;
		this.nickname=nickname;
	}
	
	

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
	
}