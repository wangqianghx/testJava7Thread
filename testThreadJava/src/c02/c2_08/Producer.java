package c02.c2_08;

// 现在轮到生产者，实现Producer类，并指定其实现Runnable接口。
public class Producer implements Runnable {
	
	// 声明两个属性：一个FileMock类对象，另一个Buffer类对象。
	private FileMock mock;
	private Buffer buffer;

	// 实现Producer类的构造器，初始化这两个属性。
	public Producer(FileMock mock, Buffer buffer) {
		this.mock = mock;
		this.buffer = buffer;
	}

	// 15.实现run()方法，读取在FileMock对象中创建的所有行，并使用insert()方法将它们存储到缓冲区。一旦这个过程结束，使用setPendingLines()方法警告缓冲区，不会再产生更多的行。
	@Override
	public void run() {
		buffer.setPendingLines(true);
		while (mock.hasMoreLines()) {
			String line = mock.getLine();
			buffer.insert(line);
		}
		buffer.setPendingLines(false);
	}
}
