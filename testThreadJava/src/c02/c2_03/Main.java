package c02.c2_03;

// ͨ����������ΪMain���Ұ���main����������ʵ�����ʾ�������ࡣ
public class Main {
	public static void main(String[] args) {
		
		// �����ʹ���һ��Cinema����
		Cinema cinema = new Cinema();
		
		// ����һ��TicketOffice1���󣬲������߳�����������
		TicketOffice1 ticketOffice1 = new TicketOffice1(cinema);
		Thread thread1 = new Thread(ticketOffice1, "TicketOffice1");
		// ����һ��TicketOffice2���󣬲������߳�����������
		TicketOffice2 ticketOffice2 = new TicketOffice2(cinema);
		Thread thread2 = new Thread(ticketOffice2, "TicketOffice2");
		
		// �����������̡߳�
		thread1.start();
		thread2.start();
		
		// �ȴ��߳�ִ����ɡ�
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// ������ӰԺ�Ŀ�ȱ��д�����̨��
		System.out.printf("Room 1 Vacancies: %d\n", cinema.getVacanciesCinema1());
		System.out.printf("Room 2 Vacancies: %d\n", cinema.getVacanciesCinema2());
	}
}