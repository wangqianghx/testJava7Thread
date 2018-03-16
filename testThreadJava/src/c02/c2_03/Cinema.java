package c02.c2_03;

// ����һ��Cinema�࣬�������long���͵����ԣ�����ΪvacanciesCinema1��vacanciesCinema2��
public class Cinema {
	
	private long vacanciesCinema1;
	private long vacanciesCinema2;
	
	// ��Cinema��������������Object���ԣ�����ΪcontrolCinema1��controlCinema2��
	private final Object controlCinema1, controlCinema2;

	// ʵ��Cinema��Ĺ��췽������ʼ���������ԡ�
	public Cinema() {
		controlCinema1 = new Object();
		controlCinema2 = new Object();
		vacanciesCinema1 = 20;
		vacanciesCinema2 = 20;
	}

	// ʵ��sellTickets1()����������һ����ӰԺ����һЩ��Ʊ����������ʹ��controlCinema1���������Ʒ���synchronized�Ĵ���顣
	public boolean sellTickets1(int number) {
		synchronized (controlCinema1) {
			if (number < vacanciesCinema1) {
				vacanciesCinema1 -= number;
				return true;
			} else {
				return false;
			}
		}
	}

	// ʵ��sellTickets2()���������ڶ�����ӰԺ����һЩ��Ʊ����������ʹ��controlCinema2���������Ʒ���synchronized�Ĵ���顣
	public boolean sellTickets2(int number) {
		synchronized (controlCinema2) {
			if (number < vacanciesCinema2) {
				vacanciesCinema2 -= number;
				return true;
			} else {
				return false;
			}
		}
	}

	// ʵ��returnTickets1()����������һ����ӰԺ���˻�һЩƱʱ����������ʹ��controlCinema1���������Ʒ���synchronized�Ĵ���顣
	public boolean returnTickets1(int number) {
		synchronized (controlCinema1) {
			vacanciesCinema1 += number;
			return true;
		}
	}

	// ʵ��returnTickets2()���������ڶ�����ӰԺ���˻�һЩƱʱ����������ʹ��controlCinema2���������Ʒ���synchronized�Ĵ���顣
	public boolean returnTickets2(int number) {
		synchronized (controlCinema2) {
			vacanciesCinema2 += number;
			return true;
		}
	}

	// ʵ������������������������ÿ����ӰԺ��ȱλ�õ�������
	public long getVacanciesCinema1() {
		return vacanciesCinema1;
	}

	public long getVacanciesCinema2() {
		return vacanciesCinema2;
	}
}
