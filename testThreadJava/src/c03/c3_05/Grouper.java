package c03.c3_05;

//25. ���ڣ�ʵ��һ���������������������������ֵ���������ʹ�ô����˾�����ÿ�������ֳ��ִ����� Results �������������㡣����һ���࣬��Ϊ Grouper ��һ��ʵ�� Runnable �ӿ�.
public class Grouper implements Runnable {

	// 26. ����һ��˽�� Results ���ԣ���Ϊ results��
	private Results results;

	// 27. ʵ����Ĺ��캯��������ʼ�� Results ���ԡ�
	public Grouper(Results results) {
		this.results = results;
	}

	// 28.ʵ�� run() ����������������array�����ֳ��ִ������ܺ͡�
	@Override
	public void run() {

		// 29. ����һ�� int ������д�ڲٿ�̨дһ����Ϣ������ʼ�����ˡ�
		int finalResult = 0;
		System.out.printf("Grouper: Processing results...\n");

		// 30. ʹ�� results ����� getData() ���������ÿ�����ֳ��ֵĴ�����Ȼ�󣬴���array��ȫ��Ԫ�أ���ÿ��Ԫ�ص�ֵ�Ӹ�
		// finalResult ������
		int data[] = results.getData();
		for (int number : data) {
			finalResult += number;
		}

		// 31. �ڲٿ�̨��ӡ�����
		System.out.printf("Grouper: Total result: %d.\n", finalResult);
	}
}