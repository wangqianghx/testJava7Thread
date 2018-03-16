package c02.c2_08;

// ���ȣ������Ǵ���һ������ģ���ı��ļ�������FileMock�࣬�����������ԣ�
// һ���ַ����������ͣ�����content����һ��int���ͣ�����index�����ǽ��洢�ļ����ݺͱ���������ģ���ļ���������
public class FileMock {

	private String content[];
	private int index;

	// ʵ��FileMock��Ĺ�������������ַ���ʼ���ļ������ݡ�
	public FileMock(int size, int length) {
		content = new String[size];
		for (int i = 0; i < size; i++) {
			StringBuilder buffer = new StringBuilder(length);
			for (int j = 0; j < length; j++) {
				int indice = (int) Math.random() * 255;
				buffer.append((char) indice);
			}
			content[i] = buffer.toString();
		}
		index = 0;
	}

	// ʵ��hasMoreLines()����������ļ��и�������������򷵻�true����������Ѿ�ȡ����ģ���ļ���β�����򷵻�false��
	public boolean hasMoreLines() {
		return index < content.length;
	}

	// ʵ��getLine()����������index������ȷ����������������ֵ��
	public String getLine() {
		if (this.hasMoreLines()) {
			System.out.println("Mock: " + (content.length - index));
			return content[index++];
		}
		return null;
	}
}
