package c01.c1_13;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;

// ����һ������Ϊ MyThreadFactory һ��ʵ�� ThreadFactory �ӿڡ�
public class MyThreadFactory implements ThreadFactory {
	
	// ���������ǣ�counter�����������������̶߳����������name���ַ�����ÿ�������̵߳����֣�stats, �ַ���list,
	// ���洴�����̶߳����ͳ�����ݡ�����ҲҪʵ����Ĺ��캯������ʼ����
	private int counter;
	private String name;
	private List<String> stats;

	public MyThreadFactory(String name) {
		counter = 0;
		this.name = name;
		stats = new ArrayList<String>();
	}

	// ʵ�� newThread() ����. �˷��� �����Runnable�ӿڲ�����һ�� Thread �������� Runnable �ӿڡ� ������,
	// ���������̶߳�������֣�Ȼ�󴴽��µ��̶߳�����󱣴�ͳ�����ݡ�
	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r, name + "-Thread_" + counter);
		counter++;
		stats.add(String.format("created thread %d with name %s on %s\n", t.getId(), t.getName(), new Date()));
		return t;
	}

	// ʵ�� getStatistics()���� ������ String ���� ȫ���Ĵ����� Thread �����ͳ�����ݡ�
	public String getStats() {
		StringBuffer buffer = new StringBuffer();
		Iterator<String> it = stats.iterator();
		while (it.hasNext()) {
			buffer.append(it.next());
			buffer.append("\n");
		}
		return buffer.toString();
	}
}
