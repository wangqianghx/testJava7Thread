package c2.c2_2;

// 实现一个类来模拟ATM，它调用subtractAmount()方法来减少账户上的余额（balance值）。这个类必须实现Runnable接口，作为一个线程执行。
public class Bank implements Runnable {
	
	// 在这个类中，添加一个Account对象。实现构造器用来初始化account的值。
	private Account account;

	public Bank(Account account) {
		this.account = account;
	}

	// 实现run()方法。它将调用100次account对象上的subtractAmount()方法，用来减少余额（balance值）。
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			account.subtractAmount(1000);
		}
	}
}