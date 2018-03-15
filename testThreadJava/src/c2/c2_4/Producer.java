package c2.c2_4;

// 创建Producer类，并指定它实现Runnable接口，它将实现这个示例的生产者。
public class Producer implements Runnable {
	
	// 声明一个EventStore对象，并实现（Producer类）构造器，初始化该对象。
	private EventStorage storage;

	public Producer(EventStorage storage) {
		this.storage = storage;
	}

	// 实现run()方法，该方法调用EventStorage对象的set()方法100次。
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			storage.set();
		}
	}
}
