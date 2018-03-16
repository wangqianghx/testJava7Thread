package c01.c1_12;

import java.util.Random;

// 创建一个类，名为 Task， 并一定要实现Runnable 接口。

public class Task implements Runnable {
	// 实现run()方法。在这里，我们将会抛出一个 AritmethicException 异常。
	// 这样，我们要用1000除以一个随机数字，直到随机生成的数为0的时候，异常就会被抛出。
	@Override
	public void run() {
		int result;
		Random random = new Random(Thread.currentThread().getId());
		while (true) {
			result = 1000 / ((int) (random.nextDouble() * 1000));
			System.out.printf("%s : f\n", Thread.currentThread().getId(), result);
			if (Thread.currentThread().isInterrupted()) {
				System.out.printf("%d : Interrupted\n", Thread.currentThread().getId());
				return;
			}
		}
	}
}
