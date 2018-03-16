package c01.c1_12;

// 现在，我们来实现例子的主类通过实现一个Main类和实现一个main() 方法.
public class Main {
	
	public static void main(String[] args) {
		
		// 创建一个 MyThreadGroup 类对象。
		MyThreadGroup threadGroup = new MyThreadGroup("MyThreadGroup");
		// 创建一个 Task 类对象.
		Task task = new Task();
		// 创建 2个 Thread 对象与这个 Task 并开始他们。
		for (int i = 0; i < 2; i++) {
			Thread t = new Thread(threadGroup, task);
			t.start();
		}
	}
}