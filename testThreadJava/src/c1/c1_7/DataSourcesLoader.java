package c1.c1_7;

import java.util.Date;
import java.util.concurrent.TimeUnit;

// ����һ������Ϊ DataSourcesLoader ��һ��ʵ��Runnable�ӿڡ�
public class DataSourcesLoader implements Runnable {
	// ʵ��run()������ ��д��Ϣ����������ʼ���У�Ȼ��˯��4�룬�����д��Ϣ�������������С�
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
