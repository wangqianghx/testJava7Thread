package c02.c2_06;

// 创建Writer类，并指定它实现Runnable接口。这个类实现了PricesInfo类属性值的修改者。
public class Writer implements Runnable {
	
	// 声明一个PricesInfo对象，并且实现Writer类的构造器来初始化这个对象。
	private PricesInfo pricesInfo;

	public Writer(PricesInfo pricesInfo) {
		this.pricesInfo = pricesInfo;
	}

	// 实现run()方法，它修改了三次两个价格的值，并且在每次修改之后睡眠2秒。
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.printf("Writer: Attempt to modify the prices.\n");
			pricesInfo.setPrices(Math.random() * 10, Math.random() * 8);
			System.out.printf("Writer: Prices have been modified.\n");
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
