package c03.c3_08;

//8. ����, ��ʵ��consumer������һ������ΪConsumer��һ��ʵ�� Runnable �ӿڡ�
import java.util.List;
import java.util.concurrent.Exchanger;

public class Consumer implements Runnable {

	// 9. ������Ϊbuffer�� List<String>����������������������໥�����ġ�
	private List<String> buffer;

	// 10. ����һ����Ϊexchanger�� Exchanger<List<String>> ��������ͬ�� producer��consumer��
	private final Exchanger<List<String>> exchanger;

	// 11. ʵ����Ĺ��캯��������ʼ��2�����ԡ�
	public Consumer(List<String> buffer, Exchanger<List<String>> exchanger) {
		this.buffer = buffer;
		this.exchanger = exchanger;
	}

	// 12. ʵ�� run() �������ڷ����ڣ�ʵ��10�ν�����
	@Override
	public void run() {
		int cycle = 1;
		for (int i = 0; i < 10; i++) {
			System.out.printf("Consumer: Cycle %d\n", cycle);

			// 13.
			// ��ÿ��ѭ�������ȵ���exchange()��������producerͬ����Consumer��Ҫ�������ݡ��˷������ܻ��׳�InterruptedException�쳣,
			// ���ϴ�����롣
			try {
				buffer = exchanger.exchange(buffer);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// 14.
			// ��producer��������buffer���10�ַ���д���ٿ�̨����buffer��ɾ�������ա�System.out.println("Consumer: "
			// + buffer.size());
			for (int j = 0; j < 10; j++) {
				String message = buffer.get(0);
				System.out.println("Consumer: " + message);
				buffer.remove(0);
			}
			cycle++;
		}
	}
}