package c03.c3_08;

import java.util.List;
import java.util.concurrent.Exchanger;

//1. ���ȣ���ʵ��producer��ʼ�ɡ�����һ������ΪProducer��һ��ʵ�� Runnable �ӿڡ�
public class Producer implements Runnable {

	// 2. ���� List<String>������Ϊ buffer�����ǵȵ�Ҫ���໥�������������͡�
	private List<String> buffer;

	// 3. ���� Exchanger<List<String>>; ������Ϊexchanger����� exchanger
	// ����������ͬ��producer��consumer�ġ�
	private final Exchanger<List<String>> exchanger;

	// 4. ʵ����Ĺ��캯������ʼ����2�����ԡ�
	public Producer(List<String> buffer, Exchanger<List<String>> exchanger) {
		this.buffer = buffer;
		this.exchanger = exchanger;
	}

	// 5. ʵ�� run() ����. �ڷ����ڣ�ʵ��10�ν�����
	@Override
	public void run() {
		int cycle = 1;
		for (int i = 0; i < 10; i++) {
			System.out.printf("Producer: Cycle %d\n", cycle);

			// 6. ��ÿ��ѭ���У���10���ַ�����buffer��
			for (int j = 0; j < 10; j++) {
				String message = "Event " + ((i * 10) + j);
				System.out.printf("Producer: %s\n", message);
				buffer.add(message);
			}

			// 7. ���� exchange() ��������consumer�������ݡ��˷������ܻ��׳�InterruptedException �쳣, ���ϴ�����롣
			try {
				buffer = exchanger.exchange(buffer);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Producer: " + buffer.size());
			cycle++;
		}
	}
}
