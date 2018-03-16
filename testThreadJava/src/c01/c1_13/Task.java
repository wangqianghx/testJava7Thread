package c01.c1_13;

import java.util.concurrent.TimeUnit;

// 创建一个类名为 Task 一定实现 Runnable接口. 对于这个例子，这些任务什么都不做只是休眠一秒。
public class Task implements Runnable {
	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
