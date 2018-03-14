package c1.c1_9;

// 现在，实现一个类抛出非检查异常。 命名此类为Task一定要实现 Runnable 接口，实现 run() 方法并刻意出异常， 例如，尝试将 string 值转化成  int 值。
public class Task implements Runnable {
	
	@Override
	public void run() {
		int numero = Integer.parseInt("TTT");
		System.out.println(numero);
	}
}
