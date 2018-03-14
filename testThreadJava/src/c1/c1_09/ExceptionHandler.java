package c1.c1_09;

import java.lang.Thread.UncaughtExceptionHandler;

// ����, ���Ǳ���ʵ��һ����������Ǽ���쳣����������ʵ�� UncaughtExceptionHandler �ӿڲ�ʵ���ڽӿ�����������uncaughtException() ������
// �������������Ϊ ExceptionHandler  �����ô˷�����д�й����׳��쳣���߳���Ϣ���쳣��Ϣ����������Ĵ��룺
public class ExceptionHandler implements UncaughtExceptionHandler {
	
	public void uncaughtException(Thread t, Throwable e) {
		System.out.printf("An exception has been captured\n");
		System.out.printf("Thread: %s\n", t.getId());
		System.out.printf("Exception: %s: %s\n", e.getClass().getName(), e.getMessage());
		System.out.printf("Stack Trace: \n");
		e.printStackTrace(System.out);
		System.out.printf("Thread status: %s\n", t.getState());
	}
}
