package c1.c1_05;

import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		// 6. ��������ʼһ��FileSearch��Ķ����һ��ִ������������̡߳�Ȼ�󣬿�ʼִ���̡߳�
//		FileSearch fileSearch = new FileSearch("C:\\wq_tools\\qycache", "livenet_cloud.cache");
		FileSearch fileSearch = new FileSearch("C:\\", "livenet_cloud.cache");
		Thread thread = new Thread(fileSearch);
		thread.start();
		// 7. ��10��Ȼ���ж��̡߳�
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.interrupt();
	}

}
