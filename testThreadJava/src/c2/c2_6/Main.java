package c2.c2_6;

// 通过创建类名为Main，且包括main（）方法来实现这个示例的主类。
public class Main {
	
	public static void main(String[] args) {
		
		// 创建一个PricesInfo对象。
		PricesInfo pricesInfo = new PricesInfo();
		
		// 创建5个Reader对象，并且用5个线程来执行它们。
		Reader readers[] = new Reader[5];
		Thread threadsReader[] = new Thread[5];
		
		for (int i = 0; i < 5; i++) {
			readers[i] = new Reader(pricesInfo);
			threadsReader[i] = new Thread(readers[i]);
		}
		// 创建一个Writer对象，并且用线程来执行它。
		Writer writer = new Writer(pricesInfo);
		Thread threadWriter = new Thread(writer);
		
		// 启动这些线程。
		for (int i = 0; i < 5; i++) {
			threadsReader[i].start();
		}
		threadWriter.start();
	}
}