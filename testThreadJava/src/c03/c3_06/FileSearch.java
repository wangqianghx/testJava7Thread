package c03.c3_06;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

//1.   ����һ������ΪFileSearch��һ��ʵ��Runnable �ӿڡ������ʵ�ֵĲ��������ļ��к������ļ���������ȷ������չ������24Сʱ���޸ĵ��ļ���
public class FileSearch implements Runnable {

	// 2. ����һ��˽�� String ����������������ʼ��ʱ����ļ��С�
	private String initPath;

	// 3. ������һ��˽�� String ��������������ҪѰ�ҵ��ļ�����չ����
	private String end;

	// 4. ����һ��˽�� List ���������������ҵ��ķ����������ļ���·����
	private List<String> results;

	// 5. �������һ��˽�� Phaser ��������������Ĳ�ͬphaser��ͬ����
	private Phaser phaser;

	// 6. ʵ����Ĺ��캯������ʼ����������ǡ������ճ�ʼ�ļ��е�·�����ļ�����չ������phaser ��Ϊ������
	public FileSearch(String initPath, String end, Phaser phaser) {
		this.initPath = initPath;
		this.end = end;
		this.phaser = phaser;
		results = new ArrayList<String>();
	}

	// 7. ���ڣ������ʵ��һЩҪ��run() �����õĸ�����������һ���� directoryProcess()
	// ������������File������Ϊ����������ȫ�����ļ������ļ��С�����ÿ���ļ��У��˷�����ݹ���ò������ļ�����Ϊ����������ÿ���ļ����˷��������fileProcess()
	// ������
	private void directoryProcess(File file) {
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
	}

	// 8. ���ڣ�ʵ�� fileProcess() ������������ File
	// ������Ϊ���������������չ���Ƿ����������ڲ��ҵġ�����ǣ��˷�������ļ��ľ���·��д�����б��ڡ�
	private void fileProcess(File file) {
		if (file.getName().endsWith(end)) {
			results.add(file.getAbsolutePath());
		}
	}

	// 9. ���ڣ�ʵ�� filterResults()
	// �������������κβ������������ڵ�һ�׶λ�õ��ļ��б���ɾ���޸ĳ���24Сʱ���ļ������ȣ�����һ���µĿ�list����õ�ǰʱ�䡣
	private void filterResults() {
		List<String> newResults = new ArrayList<String>();
		long actualDate = new Date().getTime();

		// 10. Ȼ��������list�������Ԫ�ء�����ÿ��·����Ϊ�ļ�����File���� go through all the elements
		// of the results list. For each path in the list of results, create a
		// File object for that file and get the last modified date for it.
		for (int i = 0; i < results.size(); i++) {
			File file = new File(results.get(i));
			long fileDate = file.lastModified();

			// 11. Ȼ�� �Ա�����ʵ���ڶԱȣ�������С��һ�죬���ļ���·�����뵽�µĽ���б�
			if (actualDate - fileDate < TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS)) {
				newResults.add(results.get(i));
			}
		}

		// 12. ��󣬰ѾɵĽ����Ϊ�µġ�
		results = newResults;
	}

	// 13. ���ڣ�ʵ�� checkResults() �������˷����ڵ�һ���͵ڶ���phase�Ľ�β�����ã���������Ƿ�Ϊ�ա��˷����������κβ�����
	private boolean checkResults() {

		// 14. ���ȣ������List�Ĵ�С�����Ϊ0������д��Ϣ���ٿ�̨���������Ȼ�����Phaser�����
		// arriveAndDeregister() ����֪ͨ���߳��Ѿ�����actual phase�����뿪phased������
		if (results.isEmpty()) {
			System.out.printf("%s: Phase %d: 0 results.\n", Thread.currentThread().getName(), phaser.getPhase());
			System.out.printf("%s: Phase %d: End.\n", Thread.currentThread().getName(), phaser.getPhase());
			phaser.arriveAndDeregister();
			return false;

			// 15. ��һ�������������list��Ԫ�أ���ô����д��Ϣ���ٿ�̨������������� Phaser���󶮵�
			// arriveAndAwaitAdvance() ������֪ͨ actual phase�����ᱻ����ֱ��phased
			// ������ȫ�������߳̽���actual phase��

		} else {
			System.out.printf("%s: Phase %d: %d results.\n", Thread.currentThread().getName(), phaser.getPhase(),
					results.size());
			phaser.arriveAndAwaitAdvance();
			return true;
		}
	}

	// 16. ���һ������������ showInfo() ��������ӡresults list ��Ԫ�ص��ٿ�̨��
	private void showInfo() {
		for (int i = 0; i < results.size(); i++) {
			File file = new File(results.get(i));
			System.out.printf("%s: %s\n", Thread.currentThread().getName(), file.getAbsolutePath());
		}
		phaser.arriveAndAwaitAdvance();
	}

	// 17. ���ڣ���ʵ�� run() ������ʹ��֮ǰ�����ĸ���������ִ�У���ʹ��Phaser�������phases��ĸı䡣���ȣ�����phaser�����
	// arriveAndAwaitAdvance() ������ֱ��ʹ���̱߳�������ɣ�������Ϊ�ŻῪʼ��
	@Override
	public void run() {
		phaser.arriveAndAwaitAdvance();
		// 18. Ȼ��д��Ϣ���ٿ�̨������������ʼ��
		System.out.printf("%s: Starting.\n", Thread.currentThread().getName());
		// 19. �鿴 initPath ���Դ�����ļ������ֲ�ʹ�� directoryProcess()
		// �������ļ��к������ļ����ڲ��Ҵ�������չ�����ļ���
		File file = new File(initPath);
		if (file.isDirectory()) {
			directoryProcess(file);
		}
		// 20. ʹ�� checkResults() ��������Ƿ��н�������û���κν���������̵߳�ִ�в�����keyword��
		if (!checkResults()) {
			return;
		}
		// 21. ʹ��filterResults() �������˽��list��
		filterResults();
		// 22. �ٴ�ʹ��checkResults() ��������Ƿ��н�������û�У������̵߳�ִ�в�����keyword��
		if (!checkResults()) {
			return;
		}
		// 23. ʹ�� showInfo() ������ӡ���յĽ��list���ٿ�̨�������̵߳ĵǼǣ�����ӡ��Ϣ�����̵߳��սᡣ
		showInfo();
		phaser.arriveAndDeregister();
		System.out.printf("%s: Work completed.\n", Thread.currentThread().getName());
	}
}
