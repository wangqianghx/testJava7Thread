package c1.c1_7;

import java.util.Date;
import java.util.concurrent.TimeUnit;

// ����һ������Ϊ NetworkConnectionsLoader ��һ��ҪRunnable�ӿڡ�
// ʵ��run()������������DataSourcesLoader���run()����һ������������˯��6�롣
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
