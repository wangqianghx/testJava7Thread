package c2.c2_4;

// ����Consumer�࣬��ָ����ʵ��Runnable�ӿڣ�����ʵ�����ʾ���������ߡ�
public class Consumer implements Runnable {
	
	// ����һ��EventStore���󣬲�ʵ�֣�Consumer�ࣩ����������ʼ���ö���
	private EventStorage storage;

	public Consumer(EventStorage storage) {
		this.storage = storage;
	}

	// ʵ��run()�������÷�������EventStorage�����get()����100�Ρ�
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			storage.get();
		}
	}
}
