package c03.c3_05;

//8.   ���ڣ�ʵ��һ������Ϊ Results���������array�ڱ��汻���ҵ������ھ����ÿ������ֵĴ�����
public class Results {

	// 9. ����˽�� int array ��Ϊ data��
	private int data[];

	// 10. ʵ����Ĺ��캯�����˹��캯������һ������arrayԪ������������Ϊ������
	public Results(int size) {
		data = new int[size];
	}

	// 11. ʵ�� setData() �������˷�������array��ĳ��λ�ú�һ��ֵ��Ϊ������Ȼ���array���Ǹ�λ���趨Ϊ�Ǹ�ֵ��
	public void setData(int position, int value) {
		data[position] = value;
	}

	// 12. ʵ�� getData() �������˷������ؽ�� array��
	public int[] getData() {
		return data;
	}
}