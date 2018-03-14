package c1.c1_09;

// 现在，实现例子主类。实现 Main类和 main() 方法.
public class Main {
	
	public static void main(String[] args) {
		// 创建 Task 对象并用线程运行它。使用 setUncaughtExceptionHandler() 方法设置非检查异常 handler 并开始执行线程。
		Task task = new Task();
		Thread thread = new Thread(task);
		thread.setUncaughtExceptionHandler(new ExceptionHandler());
		thread.start();
	}
}
