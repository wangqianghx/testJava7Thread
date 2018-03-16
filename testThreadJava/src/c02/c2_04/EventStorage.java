package c02.c2_04;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

// ����EventStorage�࣬����һ����ΪmaxSize������Ϊint�����Ժ�һ����Ϊstorage������ΪLinkedList<Date>�����ԡ�
public class EventStorage {

	private int maxSize;
	private List<Date> storage;

	// ʵ�������Ĺ���������ʼ���������ԡ�
	public EventStorage() {
		maxSize = 10;
		storage = new LinkedList<Date>();
	}

	// ʵ��synchronized����set()��������storage�ϴ洢һ���¼������ȣ����storage�Ƿ�������������ˣ�����wait()��
	// ����ֱ��storage�пյĿռ䡣�ڷ�����β�������ǵ���notifyAll()���������ѣ�������wait()������˯�ߵ��̡߳�
	public synchronized void set() {
		while (storage.size() == maxSize) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		((LinkedList<Date>) storage).offer(new Date());
		System.out.printf("%s Set: %d \n", Thread.currentThread().getName(), storage.size());
		notifyAll();
	}

	// ʵ��synchronized����get()��������storage�ϻ�ȡһ���¼������ȣ����storage�Ƿ����¼������û�У�����wait()��
	// ��ֱ����storage��һЩ�¼����ڷ�����β�������ǵ���notifyAll()���������ѣ�������wait()������˯�ߵ��̡߳�
	public synchronized void get() {
		while (storage.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("Get: %d: %s \n", storage.size(), ((LinkedList<?>) storage).poll());
		notifyAll();
	}
}
