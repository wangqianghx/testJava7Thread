package c03.c3_06;

import java.util.concurrent.Phaser;

//24. ���ڣ�ʵ�����ӵ�main ��ͨ����������Ϊ Main ��Ϊ����� main() ������
public class Main {

	public static void main(String[] args) {
		// 25. ���� ��3�������ߵ� Phaser ����
		Phaser phaser = new Phaser(3);
		// 26. ����3�� FileSearch ����ÿ���ڲ�ͬ�ĳ�ʼ�ļ���������.log��չ�����ļ���
		FileSearch system = new FileSearch("C:\\Windows", "log", phaser);
		FileSearch apps = new FileSearch("C:\\Program Files", "log", phaser);
		FileSearch documents = new FileSearch("C:\\Users\\Administrator", "log", phaser);
		// 27. ��������ʼһ���߳���ִ�е�һ�� FileSearch ����
		Thread systemThread = new Thread(system, "System");
		systemThread.start();
		// 28. ��������ʼһ���߳���ִ�еڶ��� FileSearch ����
		Thread appsThread = new Thread(apps, "Apps");
		appsThread.start();
		// 29. ��������ʼһ���߳���ִ�е����� FileSearch ����
		Thread documentsThread = new Thread(documents, "Documents");
		documentsThread.start();
		// 30. �ȴ�3���߳��ǵ��սᡣ
		try {
			systemThread.join();
			appsThread.join();
			documentsThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 31. ʹ��isFinalized()������Phaser����Ľ�����־ֵд��ٿ�̨��
		System.out.println("Terminated: " + phaser.isTerminated());
	}
}
