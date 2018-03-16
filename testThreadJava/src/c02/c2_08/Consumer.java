package c02.c2_08;

import java.util.Random;

//16.接下来轮到消费者，实现Consumer类，并指定它实现Runnable接口。
public class Consumer implements Runnable {
	// 17.声明Buffer对象，实现Consumer构造器来初始化这个对象。
	private Buffer buffer;

	public Consumer(Buffer buffer) {
		this.buffer = buffer;
	}

	// 实现run()方法，当缓冲区有等待的行，它将获取一个并处理它。
	@Override
	public void run() {
		while (buffer.hasPendingLines()) {
			String line = buffer.get();
			processLine(line);
		}
	}

	// 19.实现辅助方法processLine()，它只睡眠10毫秒，用来模拟某种行的处理。
	private void processLine(String line) {
		try {
			Random random = new Random();
			Thread.sleep(random.nextInt(100));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
