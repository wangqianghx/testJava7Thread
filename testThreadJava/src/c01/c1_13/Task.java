package c01.c1_13;

import java.util.concurrent.TimeUnit;

// ����һ������Ϊ Task һ��ʵ�� Runnable�ӿ�. ����������ӣ���Щ����ʲô������ֻ������һ�롣
public class Task implements Runnable {
	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
