package c2.c2_4;

// 通过创建类名为Main，且包括main（）方法来实现这个示例的主类。
public class Main {
	
	public static void main(String[] args) {
		
		// 创建一个EventStorage对象。
		EventStorage storage = new EventStorage();
		
		// 创建一个Producer对象，并且用线程运行它。
		Producer producer = new Producer(storage);
		Thread thread1 = new Thread(producer);
		// 创建一个Consumer对象，并且用线程运行它。
		Consumer consumer = new Consumer(storage);
		Thread thread2 = new Thread(consumer);
		
		// 启动这两个线程。
		thread2.start();
		thread1.start();
	}
}