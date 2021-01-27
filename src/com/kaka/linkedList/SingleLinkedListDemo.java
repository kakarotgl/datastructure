package com.kaka.linkedList;

public class SingleLinkedListDemo {
	public static void main(String[] args) {
		//���в���
		//�ߴ����ڵ�
		HeroNode hero1 = new HeroNode(1, "�ɽ�", "��ʱ��");
		HeroNode hero2 = new HeroNode(2, "¬����", "������");
		HeroNode hero3 = new HeroNode(3, "����", "�Ƕ���");
		HeroNode hero4 = new HeroNode(4, "�ֳ�", "����ͷ");
		
		//��������
		SingleLinkedList singleLinkedList = new SingleLinkedList();
//		//˳�����
//		singleLinkedList.add(hero1);
//		singleLinkedList.add(hero4);
//		singleLinkedList.add(hero3);
//		singleLinkedList.add(hero2);
		
		//����Ŵ�С�������
		singleLinkedList.addByOrder(hero1);
		singleLinkedList.addByOrder(hero4);
		singleLinkedList.addByOrder(hero3);
		singleLinkedList.addByOrder(hero2);
		//singleLinkedList.addByOrder(hero4);
		
		//��ʾһ��.�޸�ǰ������
		System.out.println("�޸�ǰ������");
		singleLinkedList.list();
		
		//�����޸Ľڵ�Ĵ���
		HeroNode newHeroNode = new HeroNode(2, "¬��", "����");
		singleLinkedList.update(newHeroNode);
		
		System.out.println("�޸ĺ������");
		//��ʾһ�ѣ��޸ĺ������
		singleLinkedList.list();
		
		//ɾ��һ���ڵ�
		singleLinkedList.del(1);
		singleLinkedList.del(2);
		singleLinkedList.del(3);
		singleLinkedList.del(4);
		singleLinkedList.del(5);
		System.out.println("ɾ��������");
		singleLinkedList.list();
		
	}

}

//����SingleLinkList�����ҵĵ�Ӣ��
class SingleLinkedList{
	//�ȳ�ʼ��һ��ͷ�ڵ㣬ͷ�ڵ㲻Ҫ��
	private HeroNode head = new HeroNode(0,"","");
	
	//��ӽڵ㵽��������
	//˼·���������Ǳ��˳��ʱ��
	//1.�ҵ���ǰ�ڵ�����ڵ�
	//2.���������ڵ��nextָ���µĽڵ�
	public void add(HeroNode heroNode) {
		//��Ϊhead�ڵ㲻�ܶ������������Ҫһ�������ڵ�temp
		HeroNode temp = head;
		//���������ҵ����
		while(true){
			//�ҵ���������
			if(temp.next==null) {
				break;
			}
			//���û���ҵ���󣬽�temp����
			temp = temp.next;
		}
		//���˳�whileѭ��ʱ��temp��ָ������������
		//����ڵ��next����ָ���µĽڵ�
		temp.next=heroNode;
	}
	
	//��ʾ����[����]
	public void list() {
		//�ж������Ƿ�Ϊ��
		if(head.next==null) {
			System.out.println("����Ϊ��");
			return;
		}
		//��Ϊͷ�ڵ㣬���ܶ������������Ҫһ����������������
		HeroNode temp = head.next;
		while(true) {
			//����ڵ����Ϣ
			System.out.println(temp);
			if(temp.next == null) {
				break;
			}
			//�ƶ�����һ��
			temp=temp.next;
		}
	}
	//�ڶ��ַ�ʽ�����Ӣ��ʱ������������Ӣ�۲��뵽ָ��λ��
		//���������������������ʧ�ܣ���������ʾ��
		public void addByOrder(HeroNode heroNode) {
			//��Ϊͷ�ڵ㲻�ܶ������������Ȼͨ��һ������ָ�루�������������ҵ���ӵ�λ��
			//��Ϊ��������Ϊ�����ҵ�temp��λ�����λ�õ�ǰһ���ڵ������벻��
			HeroNode temp = head;
			boolean flag = false; //flag��־��ӵı���Ƿ���ڣ�Ĭ��Ϊfalse
			while (true) {
				if(temp.next == null) {//˵��temp�Ѿ�����������
					break;
				}
				if(temp.next.no > heroNode.no) {//˵��temp�Ѿ�����������
					break;
				}else if(temp.next.no == heroNode.no) {
					flag = true; //˵����Ŵ���
				}
				temp = temp.next;//���ƣ���������
			}
			//�ж�flag��ֵ
			if(flag) {//������ӣ�˵����Ŵ���
				System.out.printf("׼�������Ӣ�۱��%d�Ѿ������ˣ����ܼ���\n",heroNode.no);
				
			}
			else {
				//���뵽�����У�temp�ĺ���
				heroNode.next =  temp.next;
				temp.next = heroNode;
			}
		}
		
		//�޸Ľڵ����Ϣ������no������޸ģ���no��Ų��ܸ�
		//˵��
		//1.����newHeroNOde��no���޸ļ���
		public void update(HeroNode newHeroNode) {
			//�ж��Ƿ�Ϊ��
			if(head.next == null) {
				System.out.println("����Ϊ��~");
				return;
			}
			//�ҵ���Ҫ�޸ĵĽڵ㣬����no���
			//����һ����������
			HeroNode temp = head.next;
			boolean flag = false;//��ʾ�Ƿ��ҵ��ýڵ�
			while(true) {
				if(temp ==null) {
					//�Ѿ�����������
				}
				if(temp.no == newHeroNode.no) {
					//�ҵ�
					flag=true;
					break;
				}
				temp = temp.next;
			}
			//����flag �ж��Ƿ��ҵ�Ҫ�޸ĵĽڵ�
			if(flag) {
				temp.name = newHeroNode.name;
				temp.nickname = newHeroNode.nickname;
			}else {
				System.out.printf("û���ҵ����%d�Ľڵ㣬�����޸�\n",newHeroNode.no);
			}
		}
		
		//ɾ���ڵ�
		//˼·
		//1.head���ܶ������������Ҫһ��temp�����ڵ��ҵ���ɾ���ڵ��ǰһ���ڵ�
		//2.˵�������ڱȽ��ǣ���temp.next.no����Ҫɾ���ڵ��no�Ƚ�
		public void del(int no) {
			HeroNode temp = head;
			boolean flag = false;//��־�Ƿ��ҵ���ɾ���ڵ�
			while(true) {
				if(temp.next == null) {
					break;
				}
				if(temp.next.no == no) {//�ҵ���һ���ڵ�����Ҫɾ���Ľڵ�
					flag=true;
					break;
				}
				temp = temp.next;//temp���ƣ�����
			}
			//�ж�flag
			if(flag) {
				//����ɾ��
				temp.next = temp.next.next;
			}else {
				System.out.printf("Ҫɾ����%d�ڵ㲻����",no);
			}
			
		}
		
}

//����HeroNode��ÿ��HeroNode,�������һ���ڵ�
class HeroNode{
	public int no;
	public String name;
	public String nickname;
	public HeroNode next;//ָ����һ���ڵ�
	
	//������
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
