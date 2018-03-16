package c01.c1_04;

// 1. 创建一个名为PrimeGenerator的类，扩展Thread类。
public class PrimeGenerator extends Thread {

	// 2. 覆盖 run()方法，写一个无限循环的while循环。在循环里，我们将从1开始处理连续的数字。
	// 对于每个数字，如果它是质数，那么，我们就把它写入到操控台。
	@Override
	public void run() {
		long number = 1L;
		while (true) {
			// 3. 处理完一个数字, 调用isInterrupted()方法来检查线程是否被中断了。
			// 如果它返回值为真，就写一个信息并结束线程的运行。
			if (isPrime(number)) {
				System.out.printf("Number %d is Prime\n", number);
			}
			if (isInterrupted()) {
				System.out.printf("The Prime Generator has been Interrupted.\n");
				return;
			}
			number++;
		}
	}

	// 4. 实现isPrime()方法. 它返回 boolean 值表明接收到的数字是否是质数。
	private boolean isPrime(long number) {
		if (number <= 2) {
			return true;
		}
		for (long i = 2; i < number; i++) {
			if ((number % i) == 0) {
				return false;
			}
		}
		return true;
	}
}
