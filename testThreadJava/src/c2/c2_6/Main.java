package c2.c2_6;

// ͨ����������ΪMain���Ұ���main����������ʵ�����ʾ�������ࡣ
public class Main {
	
	public static void main(String[] args) {
		
		// ����һ��PricesInfo����
		PricesInfo pricesInfo = new PricesInfo();
		
		// ����5��Reader���󣬲�����5���߳���ִ�����ǡ�
		Reader readers[] = new Reader[5];
		Thread threadsReader[] = new Thread[5];
		
		for (int i = 0; i < 5; i++) {
			readers[i] = new Reader(pricesInfo);
			threadsReader[i] = new Thread(readers[i]);
		}
		// ����һ��Writer���󣬲������߳���ִ������
		Writer writer = new Writer(pricesInfo);
		Thread threadWriter = new Thread(writer);
		
		// ������Щ�̡߳�
		for (int i = 0; i < 5; i++) {
			threadsReader[i].start();
		}
		threadWriter.start();
	}
}