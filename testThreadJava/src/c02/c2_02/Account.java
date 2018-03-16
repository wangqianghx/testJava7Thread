package c02.c2_02;

// ����һ��Account����ģ�����ǵ������˻�����ֻ��һ��double���͵����ԣ���Ϊbalance��
public class Account {
	
	private double balance;

	// ʵ��setBalance()��getBalance()������д�Ͷ�balance���Ե�ֵ��
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	// ʵ��һ��addAmount()�������������ݴ���Ĳ�������balance��ֵ��
	// ����Ӧ��ֻ��һ���߳��ܸı�balance��ֵ������ʹ��synchronized�ؼ��ֽ��������ת�����ٽ�����
	public synchronized void addAmount(double amount) {
		double tmp = balance;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tmp += amount;
		balance = tmp;
	}

	// ʵ��һ��subtractAmount()�������������ݴ���Ĳ�������balance��ֵ������Ӧ��ֻ��һ���߳��ܸı�balance��ֵ������ʹ��synchronized�ؼ��ֽ��������ת�����ٽ�����
	public synchronized void subtractAmount(double amount) {
		double tmp = balance;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tmp -= amount;
		balance = tmp;
	}
}