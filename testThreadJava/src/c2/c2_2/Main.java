package c2.c2_2;

// ͨ������һ���࣬����Ϊmain������main()������ʵ��Ӧ�ó�������ࡣ
public class Main {
	
	public static void main(String[] args) {
		
		// ����һ��Account���󣬲��ҳ�ʼ��balanceֵΪ1000��
		Account account = new Account();
		account.setBalance(1000);
		
		// ����һ��Company���󣬲�����һ���߳�����������
		Company company = new Company(account);
		Thread companyThread = new Thread(company);
		// ����һ��Bank���󣬲�����һ���߳�����������
		Bank bank = new Bank(account);
		Thread bankThread = new Thread(bank);
		
		// �ڿ���̨��ӡbalance��ʼֵ��
		System.out.printf("Account : Initial Balance: %f\n", account.getBalance());
		companyThread.start();
		bankThread.start();
		// �ȴ�����ʹ��join()�����������̣߳������ڿ���̨��ӡ�˻���������balanceֵ����
		try {
			companyThread.join();
			bankThread.join();
			System.out.printf("Account : Final Balance: %f\n", account.getBalance());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
