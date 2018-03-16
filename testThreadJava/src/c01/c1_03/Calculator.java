package c01.c1_03;

// 1. ����һ������Ϊ Calculator�������һ��Ҫʵ��Runnable�ӿڡ�
public class Calculator implements Runnable {

	// 2. ����һ����Ϊnumber��private intΪ���ԣ�Ȼ��ʵ����Ĺ��캯������ʼ����ֵ��
	private int number;

	public Calculator(int number) {
		this.number = number;
	}

	// 3. ʵ�ַ���run()���˷����Ǹ����Ǵ������߳�ִ���´�ָ��ģ�����������������㲢�Ҵ�ӡ���ֳ˷���
	@Override
	public void run() {
		for (int i = 1; i < 10; i++) {
			System.out.printf("%s: %d * %d = %d\n", Thread.currentThread().getName(), number, i,
					i * number);
		}
	}

}
