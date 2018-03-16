package c01.c1_10;

import java.util.Date;
import java.util.concurrent.TimeUnit;

// 如在之前提到的, 我们会使用本地线程变量机制来解决这个问题。
// 创建一个类名为 SafeTask a一定实现 Runnable 接口。
public class SafeTask implements Runnable {

	// 声明 ThreadLocal<Date> 类对象。此对象有隐含实现了 initialValue()方法. 此方法会返回真实日期。
	private static ThreadLocal<Date> startDate = new ThreadLocal<Date>() {
		protected Date initialValue() {
			return new Date();
		}
	};

	// 实现run()方法。它和 UnsafeClass的run() 方法功能一样，只是改变了属性的访问方式。
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