package c2.c2_4;

// ����Producer�࣬��ָ����ʵ��Runnable�ӿڣ�����ʵ�����ʾ���������ߡ�
public class Producer implements Runnable {
	
	// ����һ��EventStore���󣬲�ʵ�֣�Producer�ࣩ����������ʼ���ö���
	private EventStorage storage;

	public Producer(EventStorage storage) {
		this.storage = storage;
	}

	// ʵ��run()�������÷�������EventStorage�����set()����100�Ρ�
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			storage.set();
		}
	}
}
