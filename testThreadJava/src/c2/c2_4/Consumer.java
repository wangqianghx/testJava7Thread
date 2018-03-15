package c2.c2_4;

// 创建Consumer类，并指定它实现Runnable接口，它将实现这个示例的消费者。
public class Consumer implements Runnable {
	
	// 声明一个EventStore对象，并实现（Consumer类）构造器，初始化该对象。
	private EventStorage storage;

	public Consumer(EventStorage storage) {
		this.storage = storage;
	}

	// 实现run()方法，该方法调用EventStorage对象的get()方法100次。
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			storage.get();
		}
	}
}
