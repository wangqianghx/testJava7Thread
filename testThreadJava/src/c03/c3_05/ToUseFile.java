package c03.c3_05;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ToUseFile {

	public static void main(String[] args) {
		try {
			File file = new File("C:\\Users\\Administrator\\file.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fileWriter = new FileWriter(file);
			for (int j = 0; j < 10000000; j++) {
				fileWriter.write(j + "\n");
			}
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
