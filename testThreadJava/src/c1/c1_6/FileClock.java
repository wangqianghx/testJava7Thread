package c1.c1_6;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FileClock implements Runnable {

	@Override
	public void run() {
		// 1. 写一个10次循环的环。在每次循环，创建一个Date对象，
		// 写入文本并调用TimeUnit 类有SECONDS属性的sleep()方法来暂停线程1秒的运行。
		// 根据这个值，线程会停止将近一秒。当然 sleep() 方法 可以抛出一个 InterruptedException 异常，
		// 我们要加入捕捉代码。被中断时，解放或关闭正在使用的线程资源是好习惯。
		for (int i = 0; i < 10; i++) {
			System.out.printf("%s\n", new Date());
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				System.out.printf("The FileClock has been interrupted");
			}
		}
	}

}
