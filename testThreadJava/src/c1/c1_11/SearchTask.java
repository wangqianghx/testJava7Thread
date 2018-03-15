package c1.c1_11;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

// 首先，创建一个类名为 Result。它会保存最先结束的线程的名字。声明一个 private String 属性名为 name 并提供相应的读值和设置值的方法。
// 创建一个类名为 SearchTask a并一定实现 Runnable 接口。
public class SearchTask implements Runnable {
	
	// 声明一个Result类的 private 属性变量并实现和初始化这类属性的构造函数。
	private Result result;

	public SearchTask(Result result) {
		this.result = result;
	}

	// 实现run()方法。 它会调用doTask() 方法和等待它结束或者接收一个 InterruptedException 异常。
	// 这方法会写信息表明开始，结束，或者线程中断。
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.printf("Thread %s: Start\n", name);
		try {
			doTask();
			result.setName(name);
		} catch (InterruptedException e) {
			System.out.printf("Thread %s: Interrupted\n", name);
			return;
		}
		System.out.printf("Thread %s: End\n", name);
	}

	// 实现 doTask() 方法。它会创建一个 Random 对象生一个随机数字并用这个数字调用 sleep() 方法 。
	private void doTask() throws InterruptedException {
		Random random = new Random((new Date()).getTime());
		int value = (int) (random.nextDouble() * 100);
		System.out.printf("Thread %s sleep seconds: %d\n", Thread.currentThread().getName(), value);
		TimeUnit.SECONDS.sleep(value);
	}
}
