package c01.c1_03;

// 1. 创建一个类名为 Calculator，这个类一定要实现Runnable接口。
public class Calculator implements Runnable {

	// 2. 声明一个名为number的private int为属性，然后实现类的构造函数并初始化其值。
	private int number;

	public Calculator(int number) {
		this.number = number;
	}

	// 3. 实现方法run()。此方法是给我们创建的线程执行下达指令的，所以这个方法将计算并且打印数字乘法表。
	@Override
	public void run() {
		for (int i = 1; i < 10; i++) {
			System.out.printf("%s: %d * %d = %d\n", Thread.currentThread().getName(), number, i,
					i * number);
		}
	}

}
