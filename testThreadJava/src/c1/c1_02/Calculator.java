package c1.c1_02;

// 1. ����һ����ΪCalculator���࣬�����Ҫʵ��Runnable�ӿڡ�
public class Calculator implements Runnable {

	// 2. ����һ����Ϊnumber ��private intΪ���ԣ�Ȼ��ʵ�ֹ��캯������ʼ����ֵ��
	private int number;

	public Calculator(int number) {
		this.number = number;
	}

	// 3. ʵ��run()����. �ⷽ���Ǹ����Ǵ������߳�ִ��ָ���������������������ֳ˷���
	@Override
	public void run() {
		for (int i = 1; i < 10; i++) {
			System.out.printf("%s: %d * %d = %d\n", Thread.currentThread().getName(), number, i,
					i * number);
		}
	}

}
