package c01.c1_07;

import java.util.Date;

// 现在， 创建一个类名为 Main，包含 main()方法。
public class Main {
	public static void main(String[] args) {
		// 创建一个 DataSourcesLoader 类对象并让线程运行它。
		DataSourcesLoader dsLoader = new DataSourcesLoader();
		Thread thread1 = new Thread(dsLoader, "DataSourceThread");
		// 创建一个 NetworkConnectionsLoader 类的对象并让线程运行它。
		NetworkConnectionsLoader ncLoader = new NetworkConnectionsLoader();
		Thread thread2 = new Thread(ncLoader, "NetworkConnectionLoad er");
		// 让2个线程对象都调用 start() 方法。
		thread1.start();
		thread2.start();
		// 2个线程都使用 join() 方法等待终结。 此方法可以抛出InterruptedException 异常, 所以要包含捕捉代码。
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 写一条信息表明程序结束。
		System.out.printf("Main: Configuration has been loaded: %s\n", new Date());
	}
}