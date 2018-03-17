package c03.c3_05;

import java.util.Random;

//1.  ���Ǵ�ʵ��2�������࿪ʼ�����ȣ�����һ������Ϊ MatrixMock�������������һ����1-10֮��� ���־������ǽ����в������֡�
public class MatrixMock {

	// 2. ����˽�� int matrix����Ϊ data��
	private int data[][];

	// 3. ʵ����Ĺ��캯�����˹��캯�������վ�����������еĳ��ȣ������ǽ�Ҫ���ҵ�������Ϊ������3������ȫ��int ���͡�
	public MatrixMock(int size, int length, int number) {

		// 4. ��ʼ�����캯����ʹ�õı����Ͷ���
		int counter = 0;
		data = new int[size][length];
		Random random = new Random();

		// 5. ���������������ÿ����һ�����־���Ҫ���ҵ����ֶԱȣ������ȣ�������counterֵ��
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < length; j++) {
				data[i][j] = random.nextInt(10);
				if (data[i][j] == number) {
					counter++;
				}
			}
		}

		// 6. ����ڲٿ�̨��ӡһ����Ϣ����ʾ���ҵ����������ɵľ�����ĳ��ִ���������Ϣ����������߳��ǻ�õ���ȷ����ġ�
		System.out.printf("Mock: There are %d ocurrences of number in generated data.\n", counter, number); // ����ע�����ַ������number��Ϊ%d.
	}

	// 7. ʵ�� getRow() �������˷�������һ�� intΪ�������Ǿ������������������������ڣ����򷵻�null��
	public int[] getRow(int row) {
		if ((row >= 0) && (row < data.length)) {
			return data[row];
		}
		return null;
	}
}