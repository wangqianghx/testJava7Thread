package c2.c2_6;

import java.util.concurrent.TimeUnit;

// 创建Reader类，并指定它实现Runnable接口。这个类实现了PricesInfo类属性值的读者。
public class Reader implements Runnable {
	
	// 声明一个PricesInfo对象，并且实现Reader类的构造器来初始化这个对象。
	private PricesInfo pricesInfo;

	public Reader(PricesInfo pricesInfo) {
		this.pricesInfo = pricesInfo;
	}

	// 实现Reader类的run()方法，它读取10次两个价格的值。
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.printf("%s: Price 1: %f\n", Thread.currentThread().getName(), pricesInfo.getPrice1());
			System.out.printf("%s: Price 2: %f\n", Thread.currentThread().getName(), pricesInfo.getPrice2());
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
