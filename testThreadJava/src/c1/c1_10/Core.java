package c1.c1_10;

import java.util.concurrent.TimeUnit;

// 现在，来实现这个有问题例子的主类。创建一个 Main  类和 main() 方法. 
// 此方法会创建一个 UnsafeTask 类的对象，并开始3个线程使用这个对象，每个线程间休眠2秒。
public class Core {
	public static void main(String[] args) {
//		UnsafeTask task = new UnsafeTask();
		SafeTask task = new SafeTask();
		for (int i = 0; i < 3; i++) {
			Thread thread = new Thread(task);
			thread.start();
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
// 在以下的裁图，你可以发现这个程序的执行结果。每个线程有着不同的开始时间，但是全部都有相同的结束时间。
