package c01.c1_04;

// 5. ����, ʵ��һ����ΪMain���࣬����ʵ��main()������ʵ�����ӵ�Mian�ࡣ
public class PrimeGeneratorMain {

	public static void main(String[] args) {
		// 6. ��������ʼһ��PrimeGenerator��Ķ���
		Thread task = new PrimeGenerator();
		task.start();
		// 7. �ȴ�5�룬Ȼ���ж� PrimeGenerator ������
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		task.interrupt();
	}

}
