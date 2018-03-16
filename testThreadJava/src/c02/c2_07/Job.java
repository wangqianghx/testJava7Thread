package c02.c2_07;

// 创建一个Job类，并指定它实现Runnable接口。
public class Job implements Runnable {
	// 声明一个PrintQueue类的对象，并通过实现类（Job类）的构造器来初始化这个对象。
	private PrintQueue printQueue;

	public Job(PrintQueue printQueue) {
		this.printQueue = printQueue;
	}

	// 实现run()方法，它使用PrintQueue对象来发送一个打印任务。
	@Override
	public void run() {
		System.out.printf("%s: Going to print a document\n", Thread.currentThread().getName());
		printQueue.printJob(new Object());
		System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
	}
}
