package c02.c2_05;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// ����PrintQueue�࣬��ʵ�ִ�ӡ���С�
public class PrintQueue {
	
	// ����һ��Lock���󣬲���ʹ��ReentrantLock���һ���¶�������ʼ������
	private final Lock queueLock = new ReentrantLock();

	// ʵ��printJob()��������������Object������Ϊ���������Ҳ��᷵���κ�ֵ��
	public void printJob(Object document) {
		// ��printJob()�����ڲ���ͨ������lock()��������ȡLock����Ŀ���Ȩ��
		queueLock.lock();
		// Ȼ�󣬰������´�����ģ���ĵ��Ĵ�ӡ��
		try {
			Long duration = (long) (Math.random() * 10000);
			System.out.println(Thread.currentThread().getName() + ":PrintQueue: Printing a Job during "
					+ (duration / 1000) + " seconds");
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// ���ͨ������unlock()�������ͷ�Lock����Ŀ��ơ�
		finally {
			queueLock.unlock();
		}
	}
}
