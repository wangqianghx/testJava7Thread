package c1.c1_13;

// 创建主类. 创建一个类名为 Main 并实现main() 方法.
public class Main {
	
	public static void main(String[] args) {
		
		// 创建 MyThreadFactory 对象和 Task 对象。
		MyThreadFactory factory = new MyThreadFactory("MyThreadFactory");
		Task task = new Task();
		// 使用 MyThreadFactory 对象创建 10 Thread 对象并开始它们.
		Thread thread;
		System.out.printf("Starting the Threads\n");
		for (int i = 0; i < 10; i++) {
			thread = factory.newThread(task);
			thread.start();
		}
		// 把线程厂的数据写入控制台。
		System.out.printf("Factory stats:\n");
		System.out.printf("%s\n", factory.getStats());
	}
}