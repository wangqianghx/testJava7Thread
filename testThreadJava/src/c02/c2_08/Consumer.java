package c02.c2_08;

import java.util.Random;

//16.�������ֵ������ߣ�ʵ��Consumer�࣬��ָ����ʵ��Runnable�ӿڡ�
public class Consumer implements Runnable {
	// 17.����Buffer����ʵ��Consumer����������ʼ���������
	private Buffer buffer;

	public Consumer(Buffer buffer) {
		this.buffer = buffer;
	}

	// ʵ��run()���������������еȴ����У�������ȡһ������������
	@Override
	public void run() {
		while (buffer.hasPendingLines()) {
			String line = buffer.get();
			processLine(line);
		}
	}

	// 19.ʵ�ָ�������processLine()����ֻ˯��10���룬����ģ��ĳ���еĴ���
	private void processLine(String line) {
		try {
			Random random = new Random();
			Thread.sleep(random.nextInt(100));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
