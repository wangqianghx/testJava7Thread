package c01.c1_12;

// ���ڣ�������ʵ�����ӵ�����ͨ��ʵ��һ��Main���ʵ��һ��main() ����.
public class Main {
	
	public static void main(String[] args) {
		
		// ����һ�� MyThreadGroup �����
		MyThreadGroup threadGroup = new MyThreadGroup("MyThreadGroup");
		// ����һ�� Task �����.
		Task task = new Task();
		// ���� 2�� Thread ��������� Task ����ʼ���ǡ�
		for (int i = 0; i < 2; i++) {
			Thread t = new Thread(threadGroup, task);
			t.start();
		}
	}
}