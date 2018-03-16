package c01.c1_13;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;

// 创建一个类名为 MyThreadFactory 一定实现 ThreadFactory 接口。
public class MyThreadFactory implements ThreadFactory {
	
	// 声明属性们：counter，整数，用来储存线程对象的数量；name，字符串，每个创建线程的名字；stats, 字符串list,
	// 储存创建的线程对象的统计数据。我们也要实现类的构造函数并初始化。
	private int counter;
	private String name;
	private List<String> stats;

	public MyThreadFactory(String name) {
		counter = 0;
		this.name = name;
		stats = new ArrayList<String>();
	}

	// 实现 newThread() 方法. 此方法 会接收Runnable接口并返回一个 Thread 对象给这个 Runnable 接口。 在这里,
	// 我们生成线程对象的名字，然后创建新的线程对象，最后保存统计数据。
	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r, name + "-Thread_" + counter);
		counter++;
		stats.add(String.format("created thread %d with name %s on %s\n", t.getId(), t.getName(), new Date()));
		return t;
	}

	// 实现 getStatistics()方法 ，返回 String 对象， 全部的创建的 Thread 对象的统计数据。
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
