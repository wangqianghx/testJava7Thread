package c1.c1_5;

import java.util.concurrent.TimeUnit;

public class FileSearchMain {

	public static void main(String[] args) {
//		FileSearch fileSearch = new FileSearch("C:\\wq_tools\\qycache", "livenet_cloud.cache");
		FileSearch fileSearch = new FileSearch("C:\\", "livenet_cloud.cache");
		Thread thread = new Thread(fileSearch);
		thread.start();

		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		thread.interrupt();
	}

}
