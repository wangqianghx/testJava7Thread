package c03.c3_08;

//15.���ڣ�ʵ�����ӵ�����ͨ������һ���࣬��ΪCore������ main() ������
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class Main {
	public static void main(String[] args) {

		// 16. ����2��buffers���ֱ��producer��consumerʹ��.
		List<String> buffer1 = new ArrayList<String>();
		List<String> buffer2 = new ArrayList<String>();

		// 17. ����Exchanger��������ͬ��producer��consumer��
		Exchanger<List<String>> exchanger = new Exchanger<List<String>>();

		// 18. ����Producer�����Consumer����
		Producer producer = new Producer(buffer1, exchanger);
		Consumer consumer = new Consumer(buffer2, exchanger);

		// 19. �����߳���ִ��producer��consumer����ʼ�̡߳�
		Thread threadProducer = new Thread(producer);
		Thread threadConsumer = new Thread(consumer);
		threadProducer.start();
		threadConsumer.start();
	}
}