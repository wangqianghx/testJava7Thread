package c1.c1_10;

import java.util.Date;
import java.util.concurrent.TimeUnit;

// 首先，我们来实现一个程序含有上述的问题。
// 创建一个类名为 UnsafeTask 并实现 Runnable 接口。 声明一个 private java.util.Date 属性.
public class UnsafeTask implements Runnable {
	
	private Date startDate;

	// 实现UnsafeTask 对象的run() 方法，此方法会初始 startDate 属性, 把值写入控制台，
	// 随机休眠一段时间，最后在写入startDate属性。
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