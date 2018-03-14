package c1.c1_7;

import java.util.Date;
import java.util.concurrent.TimeUnit;

// 创建一个类名为 NetworkConnectionsLoader 并一定要Runnable接口。
// 实现run()方法。它将与DataSourcesLoader类的run()方法一样，但是它会睡眠6秒。
public class NetworkConnectionsLoader implements Runnable{
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
