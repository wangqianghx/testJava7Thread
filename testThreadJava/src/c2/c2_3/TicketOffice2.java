package c2.c2_3;

// ʵ��TicketOffice2�࣬��ָ����ʵ��Runnable�ӿڡ�
public class TicketOffice2 implements Runnable {
	
	// ����һ��Cinema���󣬲�ʵ�ָ��ࣨ��TicketOffice2���Ĺ�����������ʼ���������
	private Cinema cinema;

	public TicketOffice2(Cinema cinema) {
		this.cinema = cinema;
	}

	// ʵ��run()����������ģ����������ӰԺ��һЩ������
	@Override
	public void run() {
		cinema.sellTickets2(2);
		cinema.sellTickets2(4);
		cinema.sellTickets1(2);
		cinema.sellTickets1(1);
		cinema.returnTickets2(2);
		cinema.sellTickets1(3);
		cinema.sellTickets2(2);
		cinema.sellTickets1(2);
	}
}
