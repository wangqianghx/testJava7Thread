package c1.c1_05;

import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		// 6. 创建并初始一个FileSearch类的对象和一个执行它的任务的线程。然后，开始执行线程。
//		FileSearch fileSearch = new FileSearch("C:\\wq_tools\\qycache", "livenet_cloud.cache");
		FileSearch fileSearch = new FileSearch("C:\\", "livenet_cloud.cache");
		Thread thread = new Thread(fileSearch);
		thread.start();
		// 7. 等10秒然后中断线程。
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.interrupt();
	}

}
