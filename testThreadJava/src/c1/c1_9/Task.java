package c1.c1_9;

// ���ڣ�ʵ��һ�����׳��Ǽ���쳣�� ��������ΪTaskһ��Ҫʵ�� Runnable �ӿڣ�ʵ�� run() ������������쳣�� ���磬���Խ� string ֵת����  int ֵ��
public class Task implements Runnable {
	
	@Override
	public void run() {
		int numero = Integer.parseInt("TTT");
		System.out.println(numero);
	}
}
