package c03.c3_04;

import java.util.concurrent.CountDownLatch;

//1.   ����һ������Ϊ Videoconference ���ر�ʵ�� Runnable �ӿڡ�����ཫʵ�� video-conference ϵͳ��
public class Videoconference implements Runnable {
	// 2. ���� CountDownLatch ������Ϊ controller��
	private final CountDownLatch controller;

	// 3. ʵ����Ĺ��캯������ʼ CountDownLatch ���ԡ�Videoconference ����ս�Ҫ�ȴ��Ĳ����ߵ���Ϊ������
	public Videoconference(int number) {
		controller = new CountDownLatch(number);
	}

	// 4. ʵ�� arrive() ������ÿ���в����ߵ��ﶼ����ô˷�����������String���͵Ĳ�����Ϊ name��
	public void arrive(String name) {
		// 5. ���ȣ������ĳĳ�����Ѿ����
		System.out.printf("%s has arrived.", name);
		// 6. Ȼ�󣬵���CountDownLatch����� countDown() ������
		controller.countDown();

		// 7. ���ʹ��CountDownLatch����� getCount() ���������һ�����ڻ�δȷ������Ĳ���������
		System.out.printf("VideoConference: Waiting for %d participants.\n", controller.getCount());
	}

	// 8. ʵ��video-conference ϵͳ��������������ÿ��Runnable�������е� run() ������
	@Override
	public void run() {

		// 9. ���ȣ�ʹ�� getCount() ������������video conference�Ĳ���ֵ��������Ϣ��
		System.out.printf("VideoConference: Initialization: %d participants.\n", controller.getCount());

		// 10. Ȼ�� ʹ�� await() �������ȴ�ȫ���Ĳ����ߡ����ڴ˷����׳� InterruptedException �쳣������Ҫ����������롣
		try {
			controller.await();

			// 11. ��������Ϣ����ȫ���������Ѿ����
			System.out.printf("VideoConference: All the participants have come\n");
			System.out.printf("VideoConference: Let's start...\n");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}