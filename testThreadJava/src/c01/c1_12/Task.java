package c01.c1_12;

import java.util.Random;

// ����һ���࣬��Ϊ Task�� ��һ��Ҫʵ��Runnable �ӿڡ�

public class Task implements Runnable {
	// ʵ��run()��������������ǽ����׳�һ�� AritmethicException �쳣��
	// ����������Ҫ��1000����һ��������֣�ֱ��������ɵ���Ϊ0��ʱ���쳣�ͻᱻ�׳���
	@Override
	public void run() {
		int result;
		Random random = new Random(Thread.currentThread().getId());
		while (true) {
			result = 1000 / ((int) (random.nextDouble() * 1000));
			System.out.printf("%s : f\n", Thread.currentThread().getId(), result);
			if (Thread.currentThread().isInterrupted()) {
				System.out.printf("%d : Interrupted\n", Thread.currentThread().getId());
				return;
			}
		}
	}
}
