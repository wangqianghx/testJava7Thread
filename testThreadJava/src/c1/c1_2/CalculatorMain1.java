package c1.c1_2;

public class CalculatorMain1 {

	// 4. ����, ʵ�ֳ����Main�ࡣ����һ����Ϊ Main���ಢ���� main() ����.
	public static void main(String[] args) {
		// 5.�� main() �����ڣ�����һ������10�ε�forѭ����
		// ��ÿ��ѭ���У�����һ�� Calculator ��Ķ���, һ��Thread��Ķ���,
		// Ȼ�󴫵� Calculator ������Ϊthread�๹�캯���Ĳ������������̶߳����start() ������
		for (int i = 1; i < 10; i++) {
			Calculator calculator = new Calculator(i);
			Thread thread = new Thread(calculator);
			thread.start();
		}
	}

}
