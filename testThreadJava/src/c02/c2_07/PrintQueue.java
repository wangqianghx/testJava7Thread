package c02.c2_07;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// ����PrintQueue�࣬��ʵ�ִ�ӡ���С�
public class PrintQueue {

	// ʵ����ʹ��Lockͬ�������ʳ���н��͵�ʾ����
	// ��PrintQueue�࣬�޸�Lock����Ĺ��죬���£�
	// boolean���͵Ĳ����ǿ����̵߳Ĺ�ƽ�Եġ�
	private Lock queueLock = new ReentrantLock(true);

	// �޸�printJob()������ʹ���������������ӡ��ģ�⣬������֮���ͷ�����
	public void printJob(Object document) {
		queueLock.lock();
		try {
			Long duration = (long) (Math.random() * 10000);
			System.out.println(Thread.currentThread().getName() + ":PrintQueue: Printing a Job during "
					+ (duration / 1000) + " seconds");
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			queueLock.unlock();
		}
		queueLock.lock();
		try {
			Long duration = (long) (Math.random() * 10000);
			System.out.println(Thread.currentThread().getName() + ":PrintQueue: Printing a Job during "
					+ (duration / 1000) + " seconds");
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			queueLock.unlock();
		}
	}
}
