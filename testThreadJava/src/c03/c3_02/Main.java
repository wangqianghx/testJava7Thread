package c03.c3_02;

//15. ʵ�����ӵ�main�࣬������Ϊ Main���ಢʵ��main()������
public class Main {
	
	public static void main(String args[]) {

		// 16. ����PrintQueue������ΪprintQueue��
		PrintQueue printQueue = new PrintQueue();

		// 17. ����10��threads��ÿ���̻߳�ִ��һ�������ĵ���print queue��Job����
		Thread thread[] = new Thread[10];
		for (int i = 0; i < 10; i++) {
			thread[i] = new Thread(new Job(printQueue), "Thread" + i);
		}

		// 18. ��󣬿�ʼ��10���߳��ǡ�
		for (int i = 0; i < 10; i++) {
			thread[i].start();
		}
	}
}
