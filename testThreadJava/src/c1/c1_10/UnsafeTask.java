package c1.c1_10;

import java.util.Date;
import java.util.concurrent.TimeUnit;

// ���ȣ�������ʵ��һ�����������������⡣
// ����һ������Ϊ UnsafeTask ��ʵ�� Runnable �ӿڡ� ����һ�� private java.util.Date ����.
public class UnsafeTask implements Runnable {
	
	private Date startDate;

	// ʵ��UnsafeTask �����run() �������˷������ʼ startDate ����, ��ֵд�����̨��
	// �������һ��ʱ�䣬�����д��startDate���ԡ�
	@Override
	public void run() {
		startDate = new Date();
		System.out.printf("Starting Thread: %s : %s\n", Thread.currentThread().getId(), startDate);
		try {
			TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Thread Finished: %s : %s\n", Thread.currentThread().getId(), startDate);
	}
}