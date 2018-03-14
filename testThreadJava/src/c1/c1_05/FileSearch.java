package c1.c1_05;

import java.io.File;

// 1. ����һ����ΪFileSearch���࣬��һ��Ҫʵ��Runnable�ӿڡ�
public class FileSearch implements Runnable {

	// 2. ����2��Ϊprivate�����ԣ�һ����Ϊ������Ҫ���ҵ��ļ�������һ����Ϊ�˳�ʼ�ļ��С�
	// Ϊ�����ʵ��һ�����캯��������ʼ����Щ���ԡ�
	private String initPath;
	private String fileName;

	public FileSearch(String initPath, String fileName) {
		super();
		this.initPath = initPath;
		this.fileName = fileName;
	}

	// 3. ΪFileSearch��ʵ��run()������ ������fileName�����ǲ���·����
	// ������ǣ��͵���processDirectory()������
	// ����������׳�һ��InterruptedException�쳣����������Ӧ��Ҫ��������
	@Override
	public void run() {
		File file = new File(initPath);
		if (file.isDirectory()) {
			try {
				directoryProcess(file);
			} catch (InterruptedException e) {
				System.out.printf("%s : The search has been interrupted",
						Thread.currentThread().getName());
			}
		}
	}

	// 4. ʵ�� directoryProcess()����������������ȡ�ļ��е��ļ������ļ��в��������ǡ�
	// ����ÿ��·������������ᴫ��·����Ϊ������ѭ�����á�
	// ����ÿ���ļ����������fileProcess()������
	// ������ȫ�����ļ����ļ��к��������߳���û�б��жϣ�
	// ��������ӣ����׳�һ��InterruptedException�쳣��
	private void directoryProcess(File file) throws InterruptedException {
		File list[] = file.listFiles();
		if (list != null) {
			for (int i = 0; i < list.length; i++) {
				if (list[i].isDirectory()) {
					directoryProcess(list[i]);
				} else {
					fileProcess(list[i]);
				}
			}
		}
		if (Thread.interrupted()) {
			throw new InterruptedException();
		}
	}

	// 5. ʵ�� processFile()�������ⷽ����Ƚ��ļ�������������Ҫ�������ļ�����
	// �������һ������дһ����Ϣ������̨���Ƚ�����̻߳�����û�б��жϣ�
	// ����������׳�һ��InterruptedException�쳣��
	private void fileProcess(File file) throws InterruptedException {
		if (file.getName().equals(fileName)) {
			System.out.printf("%s : %s\n", Thread.currentThread().getName(),
					file.getAbsolutePath());
		}
		if (Thread.interrupted()) {
			throw new InterruptedException();
		}
	}

}
