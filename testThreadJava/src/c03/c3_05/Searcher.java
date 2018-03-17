package c03.c3_05;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

//13. ���������˸����࣬��ʱ����ʵ���߳��ˡ����ȣ�ʵ�� Searcher �ࡣ��������������ֵľ����е��ض�������������֡�����һ������ΪSearcher ��һ��ʵ��  Runnable �ӿ�.
public class Searcher implements Runnable {

	// 14. ����2��˽��int������Ϊ firstRow �� lastRow����2������������ȷ����Ҫ�õ��Ӽ����С�
	private int firstRow;
	private int lastRow;

	// 15. ����һ��˽�� MatrixMock ���ԣ���Ϊ mock��
	private MatrixMock mock;

	// 16. ����һ��˽�� Results ���ԣ���Ϊ results��
	private Results results;

	// 17. ����һ��˽�� int ������Ϊ number��������������Ҫ���ҵ����֡�
	private int number;

	// 18. ����һ�� CyclicBarrier ������Ϊ barrier��
	private final CyclicBarrier barrier;

	// 19. ʵ����Ĺ��캯��������ʼ��֮ǰ������ȫ�����ԡ�
	public Searcher(int firstRow, int lastRow, MatrixMock mock, Results results, int number, CyclicBarrier barrier) {
		this.firstRow = firstRow;
		this.lastRow = lastRow;
		this.mock = mock;
		this.results = results;
		this.number = number;
		this.barrier = barrier;
	}

	// 20. ʵ�� run() �����������������֡���ʹ���ڲ���������Ϊcounter����������������ÿ�г��ֵĴ�����
	@Override
	public void run() {
		int counter;

		// 21. �ڲٿ�̨��ӡһ����Ϣ���������䵽���������С�
		System.out.printf("%s: Processing lines from %d to %d.\n", Thread.currentThread().getName(), firstRow, lastRow);

		// 22. ������������̵߳�ȫ���С�����ÿ�У���¼���ڲ��ҵ����ֳ��ֵĴ�������������ڵ� Results �����б�������ݡ�
		for (int i = firstRow; i < lastRow; i++) {
			int row[] = mock.getRow(i);
			counter = 0;
			for (int j = 0; j < row.length; j++) {
				if (row[j] == number) {
					counter++;
				}
			}

			results.setData(i, counter);
		}

		// 23. ��ӡ��Ϣ���ٿ�̨�����˶����Ѿ�����������
		System.out.printf("%s: Lines processed.\n", Thread.currentThread().getName());

		// 24. ���� CyclicBarrier ����� await() ���� �����ڿ����׳����쳣��Ҫ���봦�� InterruptedException and
		// BrokenBarrierException �쳣�ı�����롣
		try {
			barrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}