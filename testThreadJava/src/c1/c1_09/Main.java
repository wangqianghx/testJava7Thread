package c1.c1_09;

// ���ڣ�ʵ���������ࡣʵ�� Main��� main() ����.
public class Main {
	
	public static void main(String[] args) {
		// ���� Task �������߳���������ʹ�� setUncaughtExceptionHandler() �������÷Ǽ���쳣 handler ����ʼִ���̡߳�
		Task task = new Task();
		Thread thread = new Thread(task);
		thread.setUncaughtExceptionHandler(new ExceptionHandler());
		thread.start();
	}
}
