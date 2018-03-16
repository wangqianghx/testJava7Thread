package c02.c2_08;

// �����ֵ������ߣ�ʵ��Producer�࣬��ָ����ʵ��Runnable�ӿڡ�
public class Producer implements Runnable {
	
	// �����������ԣ�һ��FileMock�������һ��Buffer�����
	private FileMock mock;
	private Buffer buffer;

	// ʵ��Producer��Ĺ���������ʼ�����������ԡ�
	public Producer(FileMock mock, Buffer buffer) {
		this.mock = mock;
		this.buffer = buffer;
	}

	// 15.ʵ��run()��������ȡ��FileMock�����д����������У���ʹ��insert()���������Ǵ洢����������һ��������̽�����ʹ��setPendingLines()�������滺�����������ٲ���������С�
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
