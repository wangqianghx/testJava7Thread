package c1.c1_10;

import java.util.concurrent.TimeUnit;

// ���ڣ���ʵ��������������ӵ����ࡣ����һ�� Main  ��� main() ����. 
// �˷����ᴴ��һ�� UnsafeTask ��Ķ��󣬲���ʼ3���߳�ʹ���������ÿ���̼߳�����2�롣
public class Core {
	public static void main(String[] args) {
//		UnsafeTask task = new UnsafeTask();
		SafeTask task = new SafeTask();
		for (int i = 0; i < 3; i++) {
			Thread thread = new Thread(task);
			thread.start();
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
// �����µĲ�ͼ������Է�����������ִ�н����ÿ���߳����Ų�ͬ�Ŀ�ʼʱ�䣬����ȫ��������ͬ�Ľ���ʱ�䡣
