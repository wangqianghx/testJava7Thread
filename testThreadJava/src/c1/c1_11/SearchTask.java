package c1.c1_11;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

// ���ȣ�����һ������Ϊ Result�����ᱣ�����Ƚ������̵߳����֡�����һ�� private String ������Ϊ name ���ṩ��Ӧ�Ķ�ֵ������ֵ�ķ�����
// ����һ������Ϊ SearchTask a��һ��ʵ�� Runnable �ӿڡ�
public class SearchTask implements Runnable {
	
	// ����һ��Result��� private ���Ա�����ʵ�ֺͳ�ʼ���������ԵĹ��캯����
	private Result result;

	public SearchTask(Result result) {
		this.result = result;
	}

	// ʵ��run()������ �������doTask() �����͵ȴ����������߽���һ�� InterruptedException �쳣��
	// �ⷽ����д��Ϣ������ʼ�������������߳��жϡ�
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.printf("Thread %s: Start\n", name);
		try {
			doTask();
			result.setName(name);
		} catch (InterruptedException e) {
			System.out.printf("Thread %s: Interrupted\n", name);
			return;
		}
		System.out.printf("Thread %s: End\n", name);
	}

	// ʵ�� doTask() ���������ᴴ��һ�� Random ������һ��������ֲ���������ֵ��� sleep() ���� ��
	private void doTask() throws InterruptedException {
		Random random = new Random((new Date()).getTime());
		int value = (int) (random.nextDouble() * 100);
		System.out.printf("Thread %s sleep seconds: %d\n", Thread.currentThread().getName(), value);
		TimeUnit.SECONDS.sleep(value);
	}
}
