package c03.c3_03;

//8.   ����һ����ΪJob���ಢһ��ʵ��Runnable �ӿڡ������ʵ�ְ��ĵ����͵���ӡ��������
public class Job implements Runnable {
	// 9. ����һ������ΪPrintQueue����ΪprintQueue��
	private PrintQueue printQueue;

	// 10. ʵ����Ĺ��캯������ʼ����������PrintQueue����
	public Job(PrintQueue printQueue) {
		this.printQueue = printQueue;
	}

	// 11. ʵ�ַ���run()��
	@Override
	public void run() {
		// 12. ���ȣ� �˷���д��Ϣ���ٿ�̨���������Ѿ���ʼִ���ˡ�
		System.out.printf("%s: Going to print a job\n", Thread.currentThread().getName());
		// 13. Ȼ�󣬵���PrintQueue �����printJob()������
		printQueue.printJob(new Object());
		// 14. ��� �˷���д��Ϣ���ٿ�̨�������Ѿ����������ˡ�
		System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
	}
}