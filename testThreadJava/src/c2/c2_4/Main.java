package c2.c2_4;

// ͨ����������ΪMain���Ұ���main����������ʵ�����ʾ�������ࡣ
public class Main {
	
	public static void main(String[] args) {
		
		// ����һ��EventStorage����
		EventStorage storage = new EventStorage();
		
		// ����һ��Producer���󣬲������߳���������
		Producer producer = new Producer(storage);
		Thread thread1 = new Thread(producer);
		// ����һ��Consumer���󣬲������߳���������
		Consumer consumer = new Consumer(storage);
		Thread thread2 = new Thread(consumer);
		
		// �����������̡߳�
		thread2.start();
		thread1.start();
	}
}