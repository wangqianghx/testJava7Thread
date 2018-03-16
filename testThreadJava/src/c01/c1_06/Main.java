package c01.c1_06;

import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) {
		// 2. 创建FileClock类的对象并让一个线程执行它。然后，开始执行线程。
		FileClock clock = new FileClock();
		Thread thread = new Thread(clock);
		thread.start();
		// 3. 在主线程调用TimeUnit类有SECONDS属性的 sleep() 方法来等待5秒。
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 4. 中断 FileClock 线程。
		thread.interrupt();
	}
}
