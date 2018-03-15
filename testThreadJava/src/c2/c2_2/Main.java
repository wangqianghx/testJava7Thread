package c2.c2_2;

// 通过创建一个类，类名为main，包含main()方法来实现应用程序的主类。
public class Main {
	
	public static void main(String[] args) {
		
		// 创建一个Account对象，并且初始化balance值为1000。
		Account account = new Account();
		account.setBalance(1000);
		
		// 创建一个Company对象，并且用一个线程来运行它。
		Company company = new Company(account);
		Thread companyThread = new Thread(company);
		// 创建一个Bank对象，并且用一个线程来运行它。
		Bank bank = new Bank(account);
		Thread bankThread = new Thread(bank);
		
		// 在控制台打印balance初始值。
		System.out.printf("Account : Initial Balance: %f\n", account.getBalance());
		companyThread.start();
		bankThread.start();
		// 等待两个使用join()方法结束的线程，并且在控制台打印账户的最终余额（balance值）。
		try {
			companyThread.join();
			bankThread.join();
			System.out.printf("Account : Final Balance: %f\n", account.getBalance());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
