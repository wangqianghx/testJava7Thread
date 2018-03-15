package c2.c2_6;

import java.util.concurrent.TimeUnit;

// ����Reader�࣬��ָ����ʵ��Runnable�ӿڡ������ʵ����PricesInfo������ֵ�Ķ��ߡ�
public class Reader implements Runnable {
	
	// ����һ��PricesInfo���󣬲���ʵ��Reader��Ĺ���������ʼ���������
	private PricesInfo pricesInfo;

	public Reader(PricesInfo pricesInfo) {
		this.pricesInfo = pricesInfo;
	}

	// ʵ��Reader���run()����������ȡ10�������۸��ֵ��
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
