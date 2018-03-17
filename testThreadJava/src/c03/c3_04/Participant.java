package c03.c3_04;

import java.util.concurrent.TimeUnit;

//12. ���� Participant �ಢʵ�� Runnable �ӿڡ�������ʾÿ��video conference�Ĳ����ߡ�
public class Participant implements Runnable {

	// 13. ����һ��˽�� Videoconference ������Ϊ conference.
	private Videoconference conference;

	// 14. ����һ��˽�� String ������Ϊ name��
	private String name;

	// 15. ʵ����Ĺ��캯������ʼ����2�����ԡ�
	public Participant(Videoconference conference, String name) {
		this.conference = conference;
		this.name = name;
	}

	// 16. ʵ�ֲ����ߵ�run() ������
	@Override
	public void run() {

		// 17. ���ȣ����߳��������һ��ʱ�䡣
		long duration = (long) (Math.random() * 10);
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 18. Ȼ��ʹ��Videoconference �����arrive() ���������������ߵĵ��
		conference.arrive(name);

	}
}