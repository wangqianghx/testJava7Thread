package c01.c1_04;

// 1. ����һ����ΪPrimeGenerator���࣬��չThread�ࡣ
public class PrimeGenerator extends Thread {

	// 2. ���� run()������дһ������ѭ����whileѭ������ѭ������ǽ���1��ʼ�������������֡�
	// ����ÿ�����֣����������������ô�����ǾͰ���д�뵽�ٿ�̨��
	@Override
	public void run() {
		long number = 1L;
		while (true) {
			// 3. ������һ������, ����isInterrupted()����������߳��Ƿ��ж��ˡ�
			// ���������ֵΪ�棬��дһ����Ϣ�������̵߳����С�
			if (isPrime(number)) {
				System.out.printf("Number %d is Prime\n", number);
			}
			if (isInterrupted()) {
				System.out.printf("The Prime Generator has been Interrupted.\n");
				return;
			}
			number++;
		}
	}

	// 4. ʵ��isPrime()����. ������ boolean ֵ�������յ��������Ƿ���������
	private boolean isPrime(long number) {
		if (number <= 2) {
			return true;
		}
		for (long i = 2; i < number; i++) {
			if ((number % i) == 0) {
				return false;
			}
		}
		return true;
	}
}
