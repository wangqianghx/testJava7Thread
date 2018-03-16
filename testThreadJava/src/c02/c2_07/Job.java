package c02.c2_07;

// ����һ��Job�࣬��ָ����ʵ��Runnable�ӿڡ�
public class Job implements Runnable {
	// ����һ��PrintQueue��Ķ��󣬲�ͨ��ʵ���ࣨJob�ࣩ�Ĺ���������ʼ���������
	private PrintQueue printQueue;

	public Job(PrintQueue printQueue) {
		this.printQueue = printQueue;
	}

	// ʵ��run()��������ʹ��PrintQueue����������һ����ӡ����
	@Override
	public void run() {
		System.out.printf("%s: Going to print a document\n", Thread.currentThread().getName());
		printQueue.printJob(new Object());
		System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
	}
}
