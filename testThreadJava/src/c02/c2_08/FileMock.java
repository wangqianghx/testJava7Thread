package c02.c2_08;

// 首先，让我们创建一个类来模拟文本文件。创建FileMock类，包括两个属性：
// 一个字符串数组类型，名叫content，另一个int类型，名叫index。它们将存储文件内容和被检索到的模拟文件的行数。
public class FileMock {

	private String content[];
	private int index;

	// 实现FileMock类的构造器，用随机字符初始化文件的内容。
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

	// 实现hasMoreLines()方法，如果文件有更多的行来处理，则返回true，如果我们已经取到了模拟文件的尾部，则返回false。
	public boolean hasMoreLines() {
		return index < content.length;
	}

	// 实现getLine()方法，返回index属性所确定的行数并增加其值。
	public String getLine() {
		if (this.hasMoreLines()) {
			System.out.println("Mock: " + (content.length - index));
			return content[index++];
		}
		return null;
	}
}
