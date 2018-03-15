package c1.c1_13;

// ��������. ����һ������Ϊ Main ��ʵ��main() ����.
public class Main {
	
	public static void main(String[] args) {
		
		// ���� MyThreadFactory ����� Task ����
		MyThreadFactory factory = new MyThreadFactory("MyThreadFactory");
		Task task = new Task();
		// ʹ�� MyThreadFactory ���󴴽� 10 Thread ���󲢿�ʼ����.
		Thread thread;
		System.out.printf("Starting the Threads\n");
		for (int i = 0; i < 10; i++) {
			thread = factory.newThread(task);
			thread.start();
		}
		// ���̳߳�������д�����̨��
		System.out.printf("Factory stats:\n");
		System.out.printf("%s\n", factory.getStats());
	}
}