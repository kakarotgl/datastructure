package com.kaka.linkedList;

public class DoubleLinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("˫������ò���");
		//�ȴ����ڵ�
		HeroNode2 hero1 = new HeroNode2(1, "�ɽ�", "��ʱ��");
		HeroNode2 hero2 = new HeroNode2(2, "¬����", "������");
		HeroNode2 hero3 = new HeroNode2(3, "����", "�Ƕ���");
		HeroNode2 hero4 = new HeroNode2(4, "�ֳ�", "����ͷ");
		
		//����һ��˫����
		DoubleLinkList doubleLinkList = new DoubleLinkList();
		doubleLinkList.add(hero1);
		doubleLinkList.add(hero2);
		doubleLinkList.add(hero3);
		doubleLinkList.add(hero4);
		
		doubleLinkList.list();
		
		//�޸�
		HeroNode2 hero5 = new HeroNode2(4, "С��", "С����");
		doubleLinkList.update(hero5);
		System.out.println("�޸ĺ�����");
		doubleLinkList.list();
		
		//ɾ��
		doubleLinkList.del(3);
		System.out.println("ɾ��������");
		doubleLinkList.list();
	}

}
class DoubleLinkList{
	//�ȳ�ʼ��һ��ͷ�ڵ㣬ͷ�ڵ㲻Ҫ��������ž��������
	private HeroNode2 head = new HeroNode2(0, "", "");
	
	//����ͷ�ڵ�
	public HeroNode2 getHead() {
		return head;
	}
	
	//��ʾ����[����]
		public void list() {
			//�ж������Ƿ�Ϊ��
			if(head.next==null) {
				System.out.println("����Ϊ��");
				return;
			}
			//��Ϊͷ�ڵ㣬���ܶ������������Ҫһ����������������
			HeroNode2 temp = head.next;
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
		//˫���������
		public void add(HeroNode2 heroNode2) {
			//��Ϊhead�ڵ㲻�ܶ������������Ҫһ�������ڵ�temp
			HeroNode2 temp = head;
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
			temp.next=heroNode2;
			heroNode2.pre = temp;
		}
	
		public void update(HeroNode2 newHeroNode2) {
			//�ж��Ƿ�Ϊ��
			if(head.next == null) {
				System.out.println("����Ϊ��~");
				return;
			}
			//�ҵ���Ҫ�޸ĵĽڵ㣬����no���
			//����һ����������
			HeroNode2 temp = head.next;
			boolean flag = false;//��ʾ�Ƿ��ҵ��ýڵ�
			while(true) {
				if(temp ==null) {
					//�Ѿ�����������
				}
				if(temp.no == newHeroNode2.no) {
					//�ҵ�
					flag=true;
					break;
				}
				temp = temp.next;
			}
			//����flag �ж��Ƿ��ҵ�Ҫ�޸ĵĽڵ�
			if(flag) {
				temp.name = newHeroNode2.name;
				temp.nickname = newHeroNode2.nickname;
			}else {
				System.out.printf("û���ҵ����%d�Ľڵ㣬�����޸�\n",newHeroNode2.no);
			}
		}
		public void del(int no) {
			HeroNode2 temp = head;
			boolean flag = false;//��־�Ƿ��ҵ���ɾ���ڵ�
			while(true) {
				if(temp == null) {
					break;
				}
				if(temp.no == no) {//�ҵ���һ���ڵ�����Ҫɾ���Ľڵ�
					flag=true;
					break;
				}
				temp = temp.next;//temp���ƣ�����
			}
			//�ж�flag
			if(flag) {
				//����ɾ��
				temp.pre.next = temp.next;
				if(temp.next != null) {//�����ǰ�ڵ����һ���ڵ㲻Ϊ��
					temp.pre = temp.next.pre;
				}
			}else {
				System.out.printf("Ҫɾ����%d�ڵ㲻����",no);
			}
			
		}
		
}

//����HeroNode��ÿ��HeroNode,�������һ���ڵ�
class HeroNode2{
	public int no;
	public String name;
	public String nickname;
	public HeroNode2 next;//ָ����һ���ڵ�
	public HeroNode2 pre; //ָ��ǰһ���ڵ�
	
	//������
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