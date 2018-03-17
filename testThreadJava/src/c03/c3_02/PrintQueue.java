package c03.c3_02;

import java.util.concurrent.Semaphore;

//1.   ����һ����ʵ��print queue������Ϊ PrintQueue��
public class PrintQueue {
	// 2. ����һ������ΪSemaphore������Ϊsemaphore��
	private final Semaphore semaphore;

	// 3. ʵ����Ĺ��캯������ʼ�ܱ���print quere�ķ��ʵ�semaphore�����ֵ��
	public PrintQueue() {
		semaphore = new Semaphore(1);
	}

	// 4. ʵ��Implement the printJob()�������˷�������ģ���ӡ�ĵ���������document������Ϊ������
	public void printJob(Object document) {
		// 5. ���ⷽ���ڣ����ȣ���������acquire()�������demaphore������������׳�
		// InterruptedException�쳣��ʹ�ñ��������������쳣�Ĵ��롣
		try {
			semaphore.acquire();
			// 6. Ȼ��ʵ��������ȴ�һ��ʱ���ģ���ӡ�ĵ����С�
			long duration = (long) (Math.random() * 10);
			System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n", Thread.currentThread().getName(),
					duration);
			Thread.sleep(duration);
			// 7. ����ͷ�semaphoreͨ������semaphore��relaser()������
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}
}
