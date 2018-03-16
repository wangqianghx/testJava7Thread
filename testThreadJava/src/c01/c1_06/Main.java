package c01.c1_06;

import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) {
		// 2. ����FileClock��Ķ�����һ���߳�ִ������Ȼ�󣬿�ʼִ���̡߳�
		FileClock clock = new FileClock();
		Thread thread = new Thread(clock);
		thread.start();
		// 3. �����̵߳���TimeUnit����SECONDS���Ե� sleep() �������ȴ�5�롣
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 4. �ж� FileClock �̡߳�
		thread.interrupt();
	}
}
