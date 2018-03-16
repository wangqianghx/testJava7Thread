package c02.c2_04;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

// 创建EventStorage类，包括一个名为maxSize，类型为int的属性和一个名为storage，类型为LinkedList<Date>的属性。
public class EventStorage {

	private int maxSize;
	private List<Date> storage;

	// 实现这个类的构造器，初始化所有属性。
	public EventStorage() {
		maxSize = 10;
		storage = new LinkedList<Date>();
	}

	// 实现synchronized方法set()，用来在storage上存储一个事件。首先，检查storage是否已满。如果满了，调用wait()方
	// 法，直到storage有空的空间。在方法的尾部，我们调用notifyAll()方法来唤醒，所有在wait()方法上睡眠的线程。
	public synchronized void set() {
		while (storage.size() == maxSize) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		((LinkedList<Date>) storage).offer(new Date());
		System.out.printf("%s Set: %d \n", Thread.currentThread().getName(), storage.size());
		notifyAll();
	}

	// 实现synchronized方法get()，用来在storage上获取一个事件。首先，检查storage是否有事件。如果没有，调用wait()方
	// 法直到，storage有一些事件，在方法的尾部，我们调用notifyAll()方法来唤醒，所有在wait()方法上睡眠的线程。
	public synchronized void get() {
		while (storage.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("Get: %d: %s \n", storage.size(), ((LinkedList<?>) storage).poll());
		notifyAll();
	}
}
