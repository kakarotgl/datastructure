package com.kaka.linkedList;
/**
 * ����ѭ��������Լɪ������
 * @author kakar
 *
 */
public class Josephu {

	public static void main(String[] args) {
		// ����һ�ѿ����������������ͱ����Ƿ�ok
		CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
		circleSingleLinkedList.addBoy(25);//�������С���ڵ�
		//circleSingleLinkedList.showBoy();
		circleSingleLinkedList.countBoy(1, 2, 25);//Ԥ�ƽ��2->4->5->3
	}

}

//����һ�����εĵ�������
class CircleSingleLinkedList{
	//����һ��first�ڵ㣬��ǰû�б��
	private Boy first = null;
	//���С���ڵ㣬������һ�����ε�����
	public void addBoy(int nums) {
		//nums��һ������У��
		if(nums <1) {
			System.out.println("nums��ֵ����ȷ");
		}
		Boy curBoy = null; //����ָ�룬����������������
		//ʹ��for���������ǵĻ�������
		for (int i = 1; i <= nums; i++) {
			//���ݱ�ţ�����С���ڵ�
			Boy boy = new Boy(i);
			//����ǵ�һ��С��
			if(i == 1) {
				first = boy;
				first.setNext(first);
				curBoy = first; //��curBoyָ���һ��С��
			}else {
				 curBoy.setNext(boy);
				 boy.setNext(first);
				 curBoy = boy;
			}
		}
	}
	
	//������ǰ�Ļ�������
	public void showBoy() {
		//�ж������Ƿ�Ϊ��
		if(first == null) {
			System.out.println("����Ϊ��");
			return;
		}
		//��Ϊfirst���ܶ������������Ȼʹ��һ������ָ����ɱ���
		Boy curBoy = first;
		while(true) {
			System.out.printf("С���ı��%d\n",curBoy.getNo());
			if(curBoy.getNext() == first) {//˵���Ѿ��������
				break;
			}
			curBoy = curBoy.getNext();//curboy����
		}
	}
	
	/**
	 * ʹ��֮ǰ��Ҫ���ɳ���Ϊnums�ĵ���ѭ������
	 * @param startNo ��ʼ������λ��
	 * @param countNum	������k����ʼ��Ȧ
	 * @param nums	��n������
	 */
	public void countBoy(int startNo,int countNum,int nums){
		//�ȶ����ݽ���У��
		if(first == null || startNo < 1 || startNo >nums) {//������Ĳ������Ƚ����ų�
			System.out.println("����������������������");
			return;
		}
		//����Ҫ������ָ�룬����С������
		Boy helper = first;
		//1.����һ������ָ�루������helper������Ӧ��ָ�����������������ڵ�
		while(true) {
			if(helper.getNext() == first) {//helper�Ѿ�ָ�������һ���ڵ㣨ʵ����helper��first�ڵ�ǰһ��������ɾ����
				break;
			}
			helper = helper.getNext();//helper����
		}
		//2.helper��first�ƶ�startNo-1�Σ����￪ʼ�����ĵ�λ����2�ſ�ʼ�����ƶ�2-1�Σ�
		for(int i = 0;i < startNo-1;i++) {
			helper = helper.getNext();
			first = first.getNext();
		}
		//3.��ʼ���ݵ�λ����ɾ��������countNum��ɾ�������¿�ʼ����ֱ���������һ��helper.getNext()=helper
		while(true) {
			if(helper.getNext() == helper) {//ֻʣ���һ��
				break;
			}
			for(int i = 0;i < countNum-1;i++) {//first����Ҫɾ���Ľڵ�
				helper = helper.getNext();
				first = first.getNext();
			}
			System.out.printf("ɾ���ڵ�%d\n",first.getNo());
			//ɾ��firstָ��Ľڵ�
			first = first.getNext();
			helper.setNext(first);
		}
		//4.ʣ�����һ���������
		System.out.printf("ɾ���ڵ�%d\n",first.getNo());
	}
}

//����һ��Boy�࣬��ʾһ���ڵ�
class Boy {
	private int no; //���
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
