package c1.c1_03;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.State;

// 4. ����, ʵ��Ӧ�õ����ࡣ����һ����ΪMain���࣬������ main() ����.
public class CalculatorMain2 {

	public static void main(String[] args) {

		// 5. ����һ����СΪ10��Thread��������һ����СΪ10��Thread.State���������潫Ҫִ�е��̺߳����ǵ�״̬��
		Thread threads[] = new Thread[10];
		Thread.State status[] = new Thread.State[10];

		// 6. ����10��Calculator��Ķ���ÿ����ʼΪ��ͬ�����֣�Ȼ��ֱ���10���߳����������ǡ�
		// ������5��������ֵ��Ϊ��ߣ�������5��������ֵΪ��͡�
		for (int i = 0; i < 10; i++) {
			threads[i] = new Thread(new Calculator(i));
			if (i % 2 == 0) {
				threads[i].setPriority(Thread.MAX_PRIORITY);
			} else {
				threads[i].setPriority(Thread.MIN_PRIORITY);
			}
			threads[i].setName("Thread " + i);
		}
		// 7. ����һ�� PrintWriter�������ڰ��߳�״̬�ĸı�д���ĵ���
		try (FileWriter file = new FileWriter(".\\logCalculatorMain2.txt");
				PrintWriter pw = new PrintWriter(file);) {
			// 8. ��10���̵߳�״̬д���ĵ������ڣ�����ΪNEW.
			for (int j = 0; j < 10; j++) {
				pw.println("Main : Status of Thread " + j + " �� " + threads[j].getState());
				status[j] = threads[j].getState();
			}

			// 9. ��ʼִ����10���߳�.
			for (int j = 0; j < 10; j++) {
				threads[j].start();
			}

			// 10. ֱ����10���߳�ִ�н��������ǻ�һֱ������ǵ�״̬�������������״̬�ı䣬�Ͱ�״̬�����ı���
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

	// 11. ʵ��һ������ writeThreadInfo()��
	// �������д�̵߳� ID, name, priority, old status, �� new status��
	private static void writeThreadInfo(PrintWriter pw, Thread thread, State state) {

		pw.printf("Main : Id %d - %s\n", thread.getId(), thread.getName());
		pw.printf("Main : Priority: %d\n", thread.getPriority());
		pw.printf("Main : Old State: %s\n", state);
		pw.printf("Main : New State: %s\n", thread.getState());
		pw.printf("Main : ***********************************\n");
	}

}
