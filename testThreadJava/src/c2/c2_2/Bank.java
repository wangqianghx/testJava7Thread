package c2.c2_2;

// ʵ��һ������ģ��ATM��������subtractAmount()�����������˻��ϵ���balanceֵ������������ʵ��Runnable�ӿڣ���Ϊһ���߳�ִ�С�
public class Bank implements Runnable {
	
	// ��������У����һ��Account����ʵ�ֹ�����������ʼ��account��ֵ��
	private Account account;

	public Bank(Account account) {
		this.account = account;
	}

	// ʵ��run()��������������100��account�����ϵ�subtractAmount()����������������balanceֵ����
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			account.subtractAmount(1000);
		}
	}
}