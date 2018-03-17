package c03.c3_03;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//1.   ����һ����ʵ��print queue������Ϊ PrintQueue��
public class PrintQueue {
	// 1. ������֮ǰ�ᵽ�ģ��㽫ʵ��semaphores���޸�print queue���ӡ���PrintQueue�ಢ����һ��boolean array��Ϊ
	// freePrinters�����array������еĵȴ���ӡ����ĺ����ڴ�ӡ�ĵ���printers��
	private boolean freePrinters[];

	// 2. ����һ������ΪSemaphore������Ϊsemaphore��
	private final Semaphore semaphore;

	// 2. ���ţ�����һ����ΪlockPrinters��Lock���󡣽�Ҫʹ���������������freePrinters array�ķ��ʡ�
	private Lock lockPrinters;

	// 3. �޸���Ĺ��캯������ʼ���������Ķ����ǡ�freePrinters array ��3��Ԫ�أ�ȫ����ʼΪ��ֵ��semaphore��3��Ϊ���ĳ�ʼֵ��
	public PrintQueue() {

		semaphore = new Semaphore(3);
		freePrinters = new boolean[3];

		for (int i = 0; i < 3; i++) {
			freePrinters[i] = true;
		}
		lockPrinters = new ReentrantLock();
	}

	// 4. �޸�printJob()������������һ����Ϊdocument�Ķ�����ΪΨһ������
	public void printJob(Object document) {

		// 5. ���ȣ�����acquire()�������semaphore�ķ��ʡ����ڴ˷������׳�
		// InterruptedException�쳣�����Ա�����봦�����Ĵ��롣
		try {
			semaphore.acquire();

			// 6. ����ʹ��˽�з��� getPrinter()����ñ����Ŵ�ӡ����Ĵ�ӡ���ĺ��롣
			int assignedPrinter = getPrinter();

			// 7. Ȼ�� ����ȴ�һ��ʱ����ʵ��ģ���ӡ�ĵ����С�
			long duration = (long) (Math.random() * 10);
			System.out.printf("%s: PrintQueue: Printing a Job in Printer%d during %d seconds\n",
					Thread.currentThread().getName(), assignedPrinter, duration);
			TimeUnit.SECONDS.sleep(duration);

			// 8. ��󣬵���release() ���������semaphore����Ǵ�ӡ��Ϊ���У�ͨ���ڶ�Ӧ��freePrinters array�����ڷ�����ֵ��
			freePrinters[assignedPrinter] = true;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}

	// 9. ʵ�� getPrinter() ����������һ��˽�з���������һ��intֵ�����������κβ�����
	private int getPrinter() {

		// 10. ���ȣ�����һ��int����������printer������ֵ��
		int ret = -1;
		// 11. Ȼ�� ���lockPrinters���� object�ķ��ʡ�
		try {
			lockPrinters.lock();
			// 12. Ȼ����freePrinters array���ҵ���һ����ֵ����һ�������б����������ֵ���޸�ֵΪfalse����Ϊ�Ȼ������ӡ���ͻᱻʹ�á�
			for (int i = 0; i < freePrinters.length; i++) {
				if (freePrinters[i]) {
					ret = i;
					freePrinters[i] = false;
					break;
				}
			}
			// 13. ��󣬽��lockPrinters���󲢷�����������Ϊ��ֵ��
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lockPrinters.unlock();
		}
		return ret;
	}
}
