package c02.c2_05;

// ͨ����������ΪMain���Ұ���main����������ʵ�����ʾ�������ࡣ
public class Main {
	
	public static void main(String[] args) {
		
		// ����һ�������PrintQueue����
		PrintQueue printQueue = new PrintQueue();
		// ����10��Job���󣬲���ʹ��10���߳����������ǡ�
		Thread thread[] = new Thread[10];
		for (int i = 0; i < 10; i++) {
			thread[i] = new Thread(new Job(printQueue), "Thread " + i);
		}
		// ������10���̡߳�
		for (int i = 0; i < 10; i++) {
			thread[i].start();
		}
	}
}
