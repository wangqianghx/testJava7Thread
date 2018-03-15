package c2.c2_8;

//20.ͨ����������ΪMain���Ұ���main����������ʵ�����ʾ�������ࡣ
public class Main {

	public static void main(String[] args) {
		// 21.����һ��FileMock����
		FileMock mock = new FileMock(100, 10);
		// 22.����һ��Buffer����
		Buffer buffer = new Buffer(20);
		// 23.����Producer���󣬲�����10���߳���������
		Producer producer = new Producer(mock, buffer);
		Thread threadProducer = new Thread(producer, "Producer");
		// 24.����Consumer���󣬲�����10���߳���������
		Consumer consumers[] = new Consumer[3];
		Thread threadConsumers[] = new Thread[3];
		for (int i = 0; i < 3; i++) {
			consumers[i] = new Consumer(buffer);
			threadConsumers[i] = new Thread(consumers[i], "Consumer " + i);
		}
		// 25.����producer��3��consumers��
		threadProducer.start();
		for (int i = 0; i < 3; i++) {
			threadConsumers[i].start();
		}
	}
}