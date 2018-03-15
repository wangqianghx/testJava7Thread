package c1.c1_11;

import java.util.concurrent.TimeUnit;

// 现在， 创建例子主类通过创建 Main 类和实现 main() 方法.
public class Main {
	public static void main(String[] args) {
		// 首先, 创建一个 ThreadGroup 对象命名 Searcher.
		ThreadGroup threadGroup = new ThreadGroup("Searcher");
		// 然后, 创建 一个 SearchTask 对象和 一个 Result 对象。
		Result result = new Result();
		SearchTask searchTask = new SearchTask(result);
		// 现在， 使用SearchTask对象创建 10个 Thread o对象。当你调用Thread
		// 类的构造函数时，传递它作为ThreadGroup对象的第一个参数。
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(threadGroup, searchTask);
			thread.start();
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("Number of Threads: %d\n", threadGroup.activeCount());
		System.out.printf("Information about the Thread Group\n");
		// 使用list() 方法写关于 ThreadGroup object对象信息。
		threadGroup.list();
		// 使用 activeCount() 和 enumerate()
		// 方法来获取线程个数和与ThreadGroup对象关联的线程的列表。我们可以用这个方法来获取信息， 例如，每个线程状态。
		Thread[] threads = new Thread[threadGroup.activeCount()];
		threadGroup.enumerate(threads);
		for (int i = 0; i < threadGroup.activeCount(); i++) {
			System.out.printf("Thread %s: %s\n", threads[i].getName(), threads[i].getState());
		}
		// 调用 waitFinish()方法. 我们等下来实现这方法。它会等待ThreadGroup对象中的其中一个线程结束。
		waitFinish(threadGroup);
		// 用interrupt() 方法中断组里的其他线程。
		threadGroup.interrupt();
	}

	// 实现 waitFinish() 方法. 它会使用 activeCount() 方法来控制到最后一个线程。
	private static void waitFinish(ThreadGroup threadGroup) {
		while (threadGroup.activeCount() > 9) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
