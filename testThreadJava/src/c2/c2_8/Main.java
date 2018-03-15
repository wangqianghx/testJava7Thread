package c2.c2_8;

//20.通过创建类名为Main，且包括main（）方法来实现这个示例的主类。
public class Main {

	public static void main(String[] args) {
		// 21.创建一个FileMock对象。
		FileMock mock = new FileMock(100, 10);
		// 22.创建一个Buffer对象。
		Buffer buffer = new Buffer(20);
		// 23.创建Producer对象，并且用10个线程运行它。
		Producer producer = new Producer(mock, buffer);
		Thread threadProducer = new Thread(producer, "Producer");
		// 24.创建Consumer对象，并且用10个线程运行它。
		Consumer consumers[] = new Consumer[3];
		Thread threadConsumers[] = new Thread[3];
		for (int i = 0; i < 3; i++) {
			consumers[i] = new Consumer(buffer);
			threadConsumers[i] = new Thread(consumers[i], "Consumer " + i);
		}
		// 25.启动producer和3个consumers。
		threadProducer.start();
		for (int i = 0; i < 3; i++) {
			threadConsumers[i].start();
		}
	}
}