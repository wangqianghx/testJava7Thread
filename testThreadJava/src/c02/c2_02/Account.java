package c02.c2_02;

// 创建一个Account类来模拟我们的银行账户。它只有一个double类型的属性，名为balance。
public class Account {
	
	private double balance;

	// 实现setBalance()和getBalance()方法来写和读balance属性的值。
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	// 实现一个addAmount()方法，用来根据传入的参数增加balance的值。
	// 由于应该只有一个线程能改变balance的值，所以使用synchronized关键字将这个方法转换成临界区。
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

	// 实现一个subtractAmount()方法，用来根据传入的参数减少balance的值。由于应该只有一个线程能改变balance的值，所以使用synchronized关键字将这个方法转换成临界区。
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