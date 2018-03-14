package c1.c1_2;

public class CalculatorMain1 {

	// 4. 现在, 实现程序的Main类。创建一个名为 Main的类并包含 main() 方法.
	public static void main(String[] args) {
		// 5.在 main() 方法内，创建一个迭代10次的for循环。
		// 在每次循环中，创建一个 Calculator 类的对象, 一个Thread类的对象,
		// 然后传递 Calculator 对象作为thread类构造函数的参数，最后调用线程对象的start() 方法。
		for (int i = 1; i < 10; i++) {
			Calculator calculator = new Calculator(i);
			Thread thread = new Thread(calculator);
			thread.start();
		}
	}

}
