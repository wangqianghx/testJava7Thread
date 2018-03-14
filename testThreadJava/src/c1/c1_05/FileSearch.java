package c1.c1_05;

import java.io.File;

// 1. 创建一个名为FileSearch的类，并一定要实现Runnable接口。
public class FileSearch implements Runnable {

	// 2. 声明2个为private的属性，一个是为了我们要查找的文件名和另一个是为了初始文件夹。
	// 为这个类实现一个构造函数，并初始化这些属性。
	private String initPath;
	private String fileName;

	public FileSearch(String initPath, String fileName) {
		super();
		this.initPath = initPath;
		this.fileName = fileName;
	}

	// 3. 为FileSearch类实现run()方法。 它会检测fileName属性是不是路径，
	// 如果它是，就调用processDirectory()方法。
	// 这个方法会抛出一个InterruptedException异常，所以我们应该要捕获它。
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

	// 4. 实现 directoryProcess()方法。这个方法会获取文件夹的文件和子文件夹并处理他们。
	// 对于每个路径，这个方法会传递路径作为参数来循环调用。
	// 对于每个文件，它会调用fileProcess()方法。
	// 处理完全部的文件和文件夹后，它会检查线程有没有被中断，
	// 在这个例子，会抛出一个InterruptedException异常。
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

	// 5. 实现 processFile()方法。这方法会比较文件的名字与我们要搜索的文件名。
	// 如果他们一样，就写一条信息到控制台。比较完后，线程会检查有没有被中断，
	// 在这里，它会抛出一个InterruptedException异常。
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
