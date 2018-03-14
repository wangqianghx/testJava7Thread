package c1.c1_03;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.State;

// 4. 现在, 实现应用的主类。创建一个名为Main的类，并包含 main() 方法.
public class CalculatorMain2 {

	public static void main(String[] args) {

		// 5. 创建一个大小为10的Thread类的数组和一个大小为10的Thread.State数组来保存将要执行的线程和它们的状态。
		Thread threads[] = new Thread[10];
		Thread.State status[] = new Thread.State[10];

		// 6. 创建10个Calculator类的对象，每个初始为不同的数字，然后分别用10个线程来运行它们。
		// 把其中5个的优先值设为最高，把另外5个的优先值为最低。
		for (int i = 0; i < 10; i++) {
			threads[i] = new Thread(new Calculator(i));
			if (i % 2 == 0) {
				threads[i].setPriority(Thread.MAX_PRIORITY);
			} else {
				threads[i].setPriority(Thread.MIN_PRIORITY);
			}
			threads[i].setName("Thread " + i);
		}
		// 7. 创建一个 PrintWriter对象用于把线程状态的改变写入文档。
		try (FileWriter file = new FileWriter(".\\logCalculatorMain2.txt");
				PrintWriter pw = new PrintWriter(file);) {
			// 8. 把10个线程的状态写入文档。现在，它成为NEW.
			for (int j = 0; j < 10; j++) {
				pw.println("Main : Status of Thread " + j + " ： " + threads[j].getState());
				status[j] = threads[j].getState();
			}

			// 9. 开始执行这10个线程.
			for (int j = 0; j < 10; j++) {
				threads[j].start();
			}

			// 10. 直到这10个线程执行结束，我们会一直检查它们的状态。如果发现它的状态改变，就把状态记入文本。
			boolean finish = false;
			while (!finish) {
				for (int j = 0; j < 10; j++) {
					if (threads[j].getState() != status[j]) {
						writeThreadInfo(pw, threads[j], status[j]);
						status[j] = threads[j].getState();
					}
				}
				finish = true;
				for (int j = 0; j < 10; j++) {
					finish = finish && (threads[j].getState() == State.TERMINATED);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 11. 实现一个方法 writeThreadInfo()，
	// 这个方法写线程的 ID, name, priority, old status, 和 new status。
	private static void writeThreadInfo(PrintWriter pw, Thread thread, State state) {

		pw.printf("Main : Id %d - %s\n", thread.getId(), thread.getName());
		pw.printf("Main : Priority: %d\n", thread.getPriority());
		pw.printf("Main : Old State: %s\n", state);
		pw.printf("Main : New State: %s\n", thread.getState());
		pw.printf("Main : ***********************************\n");
	}

}
