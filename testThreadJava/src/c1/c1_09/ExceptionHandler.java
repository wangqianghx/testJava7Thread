package c1.c1_09;

import java.lang.Thread.UncaughtExceptionHandler;

// 首先, 我们必须实现一个类来处理非检查异常。这个类必须实现 UncaughtExceptionHandler 接口并实现在接口内已声明的uncaughtException() 方法。
// 在这里，命名此类为 ExceptionHandler  ，并让此方法里写有关于抛出异常的线程信息和异常信息，按照下面的代码：
public class ExceptionHandler implements UncaughtExceptionHandler {
	
	public void uncaughtException(Thread t, Throwable e) {
		System.out.printf("An exception has been captured\n");
		System.out.printf("Thread: %s\n", t.getId());
		System.out.printf("Exception: %s: %s\n", e.getClass().getName(), e.getMessage());
		System.out.printf("Stack Trace: \n");
		e.printStackTrace(System.out);
		System.out.printf("Thread status: %s\n", t.getState());
	}
}
