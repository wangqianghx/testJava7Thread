package c2.c2_2;

// ʵ��һ������ģ�⹫˾��������addAmount()�����������˻��ϵ���balanceֵ������������ʵ��Runnable�ӿڣ���Ϊһ���߳�ִ�С�
public class Company implements Runnable {
	
	// ��������У����һ��Account����ʵ�ֹ�����������ʼ��account��ֵ��
	private Account account;

	public Company(Account account) {
		this.account = account;
	}

	// ʵ��run()��������������100��account�����ϵ�addAmount()����������������balanceֵ����
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			account.addAmount(1000);
		}
	}
}