package c02.c2_05;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 创建PrintQueue类，来实现打印队列。
public class PrintQueue {
	
	// 声明一个Lock对象，并且使用ReentrantLock类的一个新对象来初始化它。
	private final Lock queueLock = new ReentrantLock();

	// 实现printJob()方法，它将接收Object对象作为参数，并且不会返回任何值。
	public void printJob(Object document) {
		// 在printJob()方法内部，通过调用lock()方法来获取Lock对象的控制权。
		queueLock.lock();
		// 然后，包含以下代码来模拟文档的打印：
		try {
			Long duration = (long) (Math.random() * 10000);
			System.out.println(Thread.currentThread().getName() + ":PrintQueue: Printing a Job during "
					+ (duration / 1000) + " seconds");
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 最后，通过调用unlock()方法来释放Lock对象的控制。
		finally {
			queueLock.unlock();
		}
	}
}
