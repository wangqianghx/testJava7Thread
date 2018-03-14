package c1.c1_7;

import java.util.Date;
import java.util.concurrent.TimeUnit;

// 创建一个类名为 DataSourcesLoader 并一定实现Runnable接口。
public class DataSourcesLoader implements Runnable {
	// 实现run()方法。 它写信息来表明它开始运行，然后睡眠4秒，最后再写信息表明它结束运行。
	@Override
	public void run() {
		System.out.printf("Beginning data sources loading: %s\n", new Date());
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Data sources loading has finished:%s\n", new Date());
	}

}
