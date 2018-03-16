package c01.c1_07;

import java.util.Date;

// ���ڣ� ����һ������Ϊ Main������ main()������
public class Main {
	public static void main(String[] args) {
		// ����һ�� DataSourcesLoader ��������߳���������
		DataSourcesLoader dsLoader = new DataSourcesLoader();
		Thread thread1 = new Thread(dsLoader, "DataSourceThread");
		// ����һ�� NetworkConnectionsLoader ��Ķ������߳���������
		NetworkConnectionsLoader ncLoader = new NetworkConnectionsLoader();
		Thread thread2 = new Thread(ncLoader, "NetworkConnectionLoad er");
		// ��2���̶߳��󶼵��� start() ������
		thread1.start();
		thread2.start();
		// 2���̶߳�ʹ�� join() �����ȴ��սᡣ �˷��������׳�InterruptedException �쳣, ����Ҫ������׽���롣
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// дһ����Ϣ�������������
		System.out.printf("Main: Configuration has been loaded: %s\n", new Date());
	}
}