package c02.c2_07;

// 通过创建类名为Main，且包括main（）方法来实现这个示例的主类。
public class Main {

	public static void main(String[] args) {

		// 创建一个共享的PrintQueue对象。
		PrintQueue printQueue = new PrintQueue();
		// 创建10个Job对象，并且使用10个线程来运行它们。
		Thread thread[] = new Thread[10];
		for (int i = 0; i < 10; i++) {
			thread[i] = new Thread(new Job(printQueue), "Thread " + i);
		}

		// 修改Main类中，启动线程的代码块。新的代码块如下：
		for (int i = 0; i < 10; i++) {
			thread[i].start();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
