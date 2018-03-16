package c01.c1_10;

import java.util.Date;
import java.util.concurrent.TimeUnit;

// ����֮ǰ�ᵽ��, ���ǻ�ʹ�ñ����̱߳������������������⡣
// ����һ������Ϊ SafeTask aһ��ʵ�� Runnable �ӿڡ�
public class SafeTask implements Runnable {

	// ���� ThreadLocal<Date> ����󡣴˶���������ʵ���� initialValue()����. �˷����᷵����ʵ���ڡ�
	private static ThreadLocal<Date> startDate = new ThreadLocal<Date>() {
		protected Date initialValue() {
			return new Date();
		}
	};

	// ʵ��run()���������� UnsafeClass��run() ��������һ����ֻ�Ǹı������Եķ��ʷ�ʽ��
	@Override
	public void run() {
		System.out.printf("Starting Thread: %s : %s\n", Thread.currentThread().getId(), startDate.get());
		try {
			TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Thread Finished: %s : %s\n", Thread.currentThread().getId(), startDate.get());
	}
}