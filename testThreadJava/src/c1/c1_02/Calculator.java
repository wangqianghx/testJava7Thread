package c1.c1_02;

// 1. 创建一个名为Calculator的类，这个类要实现Runnable接口。
public class Calculator implements Runnable {

	// 2. 声明一个名为number 的private int为属性，然后实现构造函数并初始化其值。
	private int number;

	public Calculator(int number) {
		this.number = number;
	}

	// 3. 实现run()方法. 这方法是给我们创建的线程执行指令，所以这个方法将计算数字乘法表。
	@Override
	public void run() {
		for (int i = 1; i < 10; i++) {
			System.out.printf("%s: %d * %d = %d\n", Thread.currentThread().getName(), number, i,
					i * number);
		}
	}

}
