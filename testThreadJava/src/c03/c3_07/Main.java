package c03.c3_07;

import c03.c3_07.MyPhaser.Student;

//17.  ʵ�����ӵ�main�࣬������ΪMain���ಢ���main() ������
public class Main {

	public static void main(String[] args) {

		// 18. ���� MyPhaser����
		MyPhaser phaser = new MyPhaser();

		// 19. ����5�� Student ����ʹ��register()������phaser��ע�����ǡ�
		MyPhaser.Student students[] = new Student[5];
		for (int i = 0; i < students.length; i++) {
			students[i] = phaser.new Student(phaser);
			phaser.register();
		}

		// 20. ����5���߳�������students����ʼ���ǡ�
		Thread threads[] = new Thread[students.length];
		for (int i = 0; i < students.length; i++) {
			threads[i] = new Thread(students[i], "Student " + i);
			threads[i].start();
		}

		// 21. �ȴ�5���̵߳��սᡣ
		for (int i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// 22. ����isTerminated()������дһ����Ϣ����phaser����termination״̬��
		System.out.printf("Main: The phaser has finished: %s.\n", phaser.isTerminated());
	}
}
