package c2.c2_3;

// ʵ��TicketOffice1�࣬��ָ����ʵ��Runnable�ӿڡ�
public class TicketOffice1 implements Runnable {
	// ����һ��Cinema���󣬲�ʵ�ָ��ࣨ��TicketOffice1���Ĺ�����������ʼ���������
	private Cinema cinema;

	public TicketOffice1(Cinema cinema) {
		this.cinema = cinema;
	}

	// ʵ��run()����������ģ����������ӰԺ��һЩ������
	@Override
	public void run() {
		cinema.sellTickets1(3);
		cinema.sellTickets1(2);
		cinema.sellTickets2(2);
		cinema.returnTickets1(3);
		cinema.sellTickets1(5);
		cinema.sellTickets2(2);
		cinema.sellTickets2(2);
		cinema.sellTickets2(2);
	}
}
