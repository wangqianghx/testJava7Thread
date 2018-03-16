package c01.c1_12;

// ����, ����һ�����MyThreadGroup����չ ThreadGroup �� �����Ǳ�������һ��ӵ��һ�������Ĺ��췽������ΪThreadGroup����һ��û�в����Ĺ��췽����
public class MyThreadGroup extends ThreadGroup {
	
	public MyThreadGroup(String name) {
		super(name);
	}
	// ���� uncaughtException() ������ThreadGroup �������һ���߳��׳��쳣ʱ���ͻ���ô˷���
	// ������������������쳣���׳������̵߳���Ϣд��ٿ�̨���ж�ThreadGroup��������̡߳�
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.printf("The thread %s has thrown an Exception\n", t.getId());
		e.printStackTrace(System.out);
		System.out.printf("Terminating the rest of the Threads\n");
		interrupt();
	}
}
