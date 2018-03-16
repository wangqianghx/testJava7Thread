package c02.c2_07;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 创建PrintQueue类，来实现打印队列。
public class PrintQueue {

	// 实现有使用Lock同步代码块食谱中解释的示例。
	// 在PrintQueue类，修改Lock对象的构造，如下：
	// boolean类型的参数是控制线程的公平性的。
	private Lock queueLock = new ReentrantLock(true);

	// 修改printJob()方法，使用两个代码块分离打印的模拟，在它们之间释放锁。
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
