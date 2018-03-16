package c01.c1_04;

// 5. 现在, 实现一个名为Main的类，包括实现main()方法来实现例子的Mian类。
public class PrimeGeneratorMain {

	public static void main(String[] args) {
		// 6. 创建并开始一个PrimeGenerator类的对象。
		Thread task = new PrimeGenerator();
		task.start();
		// 7. 等待5秒，然后中断 PrimeGenerator 方法。
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		task.interrupt();
	}

}
