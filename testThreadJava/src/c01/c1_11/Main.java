package c01.c1_11;

import java.util.concurrent.TimeUnit;

// ���ڣ� ������������ͨ������ Main ���ʵ�� main() ����.
public class Main {
	public static void main(String[] args) {
		// ����, ����һ�� ThreadGroup �������� Searcher.
		ThreadGroup threadGroup = new ThreadGroup("Searcher");
		// Ȼ��, ���� һ�� SearchTask ����� һ�� Result ����
		Result result = new Result();
		SearchTask searchTask = new SearchTask(result);
		// ���ڣ� ʹ��SearchTask���󴴽� 10�� Thread o���󡣵������Thread
		// ��Ĺ��캯��ʱ����������ΪThreadGroup����ĵ�һ��������
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(threadGroup, searchTask);
			thread.start();
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("Number of Threads: %d\n", threadGroup.activeCount());
		System.out.printf("Information about the Thread Group\n");
		// ʹ��list() ����д���� ThreadGroup object������Ϣ��
		threadGroup.list();
		// ʹ�� activeCount() �� enumerate()
		// ��������ȡ�̸߳�������ThreadGroup����������̵߳��б����ǿ����������������ȡ��Ϣ�� ���磬ÿ���߳�״̬��
		Thread[] threads = new Thread[threadGroup.activeCount()];
		threadGroup.enumerate(threads);
		for (int i = 0; i < threadGroup.activeCount(); i++) {
			System.out.printf("Thread %s: %s\n", threads[i].getName(), threads[i].getState());
		}
		// ���� waitFinish()����. ���ǵ�����ʵ���ⷽ��������ȴ�ThreadGroup�����е�����һ���߳̽�����
		waitFinish(threadGroup);
		// ��interrupt() �����ж�����������̡߳�
		threadGroup.interrupt();
	}

	// ʵ�� waitFinish() ����. ����ʹ�� activeCount() ���������Ƶ����һ���̡߳�
	private static void waitFinish(ThreadGroup threadGroup) {
		while (threadGroup.activeCount() > 9) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
