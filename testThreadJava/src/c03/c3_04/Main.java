package c03.c3_04;

//19. ���ʵ�����ӵ� main ��ͨ������һ����Ϊ Main ���ಢΪ����� main() ������
public class Main {
	
	public static void main(String[] args) {
		
		// 20. ���� Videoconference ������Ϊ conference�����ȴ�10�������ߡ�
		Videoconference conference = new Videoconference(10);
		// 21. ���� Thread ��������� Videoconference ���󲢿�ʼ���С�
		Thread threadConference = new Thread(conference);
		threadConference.start();
		// 22. ���� 10�� Participant ����Ϊÿ�����������һ�� Thread �������������ǣ���ʼ����ȫ�����̡߳�
		for (int i = 0; i < 10; i++) {
			Participant p = new Participant(conference, "Participant " + i);
			Thread t = new Thread(p);
			t.start();
		}
	}
}
