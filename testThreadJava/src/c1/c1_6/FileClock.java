package c1.c1_6;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FileClock implements Runnable {

	@Override
	public void run() {
		// 1. дһ��10��ѭ���Ļ�����ÿ��ѭ��������һ��Date����
		// д���ı�������TimeUnit ����SECONDS���Ե�sleep()��������ͣ�߳�1������С�
		// �������ֵ���̻߳�ֹͣ����һ�롣��Ȼ sleep() ���� �����׳�һ�� InterruptedException �쳣��
		// ����Ҫ���벶׽���롣���ж�ʱ����Ż�ر�����ʹ�õ��߳���Դ�Ǻ�ϰ�ߡ�
		for (int i = 0; i < 10; i++) {
			System.out.printf("%s\n", new Date());
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				System.out.printf("The FileClock has been interrupted");
			}
		}
	}

}
