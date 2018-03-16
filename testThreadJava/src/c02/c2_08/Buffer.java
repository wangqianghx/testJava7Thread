package c02.c2_08;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// ���ڣ�ʵ��Buffer�࣬����ʵ������������������֮�乲��Ļ�������
public class Buffer {
	// Buffer�࣬��6�����ԣ�
	// һ������ΪLinkedList<String>����Ϊbuffer�����ԣ������洢��������
	// һ������Ϊint����ΪmaxSize�����ԣ������洢�������ĳ���
	// һ����Ϊlock��ReentrantLock�������������޸Ļ����������ķ���
	// �������ֱ�Ϊlines��space������ΪCondition������
	// һ��Boolean���ͣ���ΪpendingLines�����ԣ��������������������
	private LinkedList<String> buffer;
	private int maxSize;
	private ReentrantLock lock;
	private Condition lines;
	private Condition space;
	private boolean pendingLines;

	// ʵ��Buffer��Ĺ���������ʼ��ǰ���������������ԡ�
	public Buffer(int maxSize) {
		this.maxSize = maxSize;
		buffer = new LinkedList<>();
		lock = new ReentrantLock();
		lines = lock.newCondition();
		space = lock.newCondition();
		pendingLines = true;
	}

	// ʵ��insert()����������һ��String���Ͳ�������ͼ�����洢�������������ȣ���������Ŀ��ơ����������Ŀ��ƣ�������黺�����Ƿ��п��п�
	// �䡣�����������������������await()������space�����ϵȴ��ͷſռ䡣��������߳���space�����ϵ���signal()��
	// signalAll()����������߳̽������ѡ��������������������߳��ڻ������ϴ洢�в�����lines�����ϵ���signallAll()��������
	// �����ǽ��ῴ��������������ỽ�������ڻ������ϵȴ����̡߳�
	public void insert(String line) {
		lock.lock();
		try {
			while (buffer.size() == maxSize) {
				space.await();
			}
			buffer.offer(line);
			System.out.printf("%s: Inserted Line: %d\n", Thread.currentThread().getName(), buffer.size());
			lines.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	// ʵ��get()�����������ش洢�ڻ������ϵĵ�һ���ַ��������ȣ�����ȡ���Ŀ��ơ�����ӵ�����Ŀ��ƣ�����黺�����Ƿ����С�����������ǿյģ�������
	// await()������lines�����ϵȴ��������е��С���������߳���lines�����ϵ���signal()��signalAll()����������߳̽�
	// �����ѡ���������ʱ�����������ȡ�����������У�������space�����ϵ���signalAll()������Ȼ�󷵻�String��
	public String get() {
		String line = null;
		lock.lock();
		try {
			while ((buffer.size() == 0) && (hasPendingLines())) {
				lines.await();
			}
			if (hasPendingLines()) {
				line = buffer.poll();
				System.out.printf("%s: Line Readed: %d\n", Thread.currentThread().getName(), buffer.size());
				space.signalAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return line;
	}

	// ʵ��setPendingLines()��������������pendingLines��ֵ����û�и����������ʱ�������������ߵ��á�
	public void setPendingLines(boolean pendingLines) {
		this.pendingLines = pendingLines;
	}

	// ʵ��hasPendingLines()����������и�����б�����ʱ������true�����򷵻�false��
	public boolean hasPendingLines() {
		return pendingLines || buffer.size() > 0;
	}
}