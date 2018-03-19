package c03.c3_07;

import java.util.Date;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

//1.   ����һ���࣬��Ϊ MyPhaser�����ر����չ Phaser �ࡣ
public class MyPhaser extends Phaser {

	// 2. ���� onAdvance() ���������� phase �����Ե�ֵ�����ǽ����ò�ͬ�ĸ������������ phase ���� 0������
	// studentsArrived() ����������� phase ���� 1������ finishFirstExercise() ����������� phase
	// ���� 2������ finishSecondExercise() ����������� phase ���� 3������ finishExam()
	// ���������򣬷�����ֵ����ʾphaser�Ѿ��սᡣ
	@Override
	protected boolean onAdvance(int phase, int registeredParties) {
		switch (phase) {
		case 0:
			return studentsArrived();
		case 1:
			return finishFirstExercise();
		case 2:
			return finishSecondExercise();
		case 3:
			return finishExam();
		default:
			return true;
		}
	}

	// 3. ʵ�ָ������� studentsArrived()�����ڲٿ�̨д2����Ϣ��������falseֵ������phaser������ִ�С�
	private boolean studentsArrived() {
		System.out.printf("Phaser: The exam are going to start. The students are ready.\n");
		System.out.printf("Phaser: We have %d students.\n", getRegisteredParties());
		return false;
	}

	// 4. ʵ�ָ������� finishFirstExercise()�����ڲٿ�̨д2����Ϣ��������falseֵ������phaser������ִ�С�
	private boolean finishFirstExercise() {
		System.out.printf("Phaser: All the students have finished the first exercise.\n");
		System.out.printf("Phaser: It's time for the second one.\n");
		return false;
	}

	// 5. ʵ�ָ������� finishSecondExercise()�����ڲٿ�̨д2����Ϣ��������falseֵ������phaser������ִ�С�
	private boolean finishSecondExercise() {
		System.out.printf("Phaser: All the students have finished the second exercise.\n");
		System.out.printf("Phaser: It's time for the third one.\n");
		return false;
	}

	// 6. ʵ�ָ������� finishExam()�����ڲٿ�̨д2����Ϣ��������falseֵ������phaser������ִ�С�
	private boolean finishExam() {
		System.out.printf("Phaser: All the students have finished the exam.\n");
		System.out.printf("Phaser: Thank you for your time.\n");
		return true;
	}

	// 7. ����һ���࣬��Ϊ Student����һ��ʵ�� Runnable �ӿڡ�����ཫģ������ѧ����
	public class Student implements Runnable {

		// 8. ���� a Phaser ������Ϊ phaser.
		private Phaser phaser;

		// 9. ʵ����Ĺ��캯������ʼ Phaser ����
		public Student(Phaser phaser) {
			this.phaser = phaser;
		}

		// 10. ʵ�� run() ������ģ����ʵ���顣
		@Override
		public void run() {

			// 11. ���ȣ�����дһ����Ϣ���ٿ�̨����ѧ�����￼�������� phaser �� arriveAndAwaitAdvance()
			// �������ȴ������߳��ǡ�
			System.out.printf("%s: Has arrived to do the exam. %s\n", Thread.currentThread().getName(), new Date());
			phaser.arriveAndAwaitAdvance();

			// 12. Ȼ��д��Ϣ���ٿ�̨������˽�� doExercise1() ����ģ���һ�����飬д��һ����Ϣ���ٿ�̨������ phaser
			// �� arriveAndAwaitAdvance() �������ȴ�����ѧ��������һ�����顣
			System.out.printf("%s: Is going to do the first exercise. %s\n", Thread.currentThread().getName(),
					new Date());
			doExercise1();
			System.out.printf("%s: Has done the first exercise. %s\n", Thread.currentThread().getName(), new Date());
			phaser.arriveAndAwaitAdvance();

			// 13. Ϊ�ڶ����͵�����ʵ����ͬ�Ĵ��롣
			System.out.printf("%s: Is going to do the second exercise.%s\n", Thread.currentThread().getName(),
					new Date());
			doExercise2();
			System.out.printf("%s: Has done the second exercise. %s\n", Thread.currentThread().getName(), new Date());
			phaser.arriveAndAwaitAdvance();
			System.out.printf("%s: Is going to do the third exercise. %s\n", Thread.currentThread().getName(),
					new Date());
			doExercise3();
			System.out.printf("%s: Has finished the exam. %s\n", Thread.currentThread().getName(), new Date());
			phaser.arriveAndAwaitAdvance();
		}

		// 14. ʵ�ָ������� doExercise1()���˷������߳��������һ��ʱ�䡣
		private void doExercise1() {
			try {
				long duration = (long) (Math.random() * 10);
				TimeUnit.SECONDS.sleep(duration);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// 15. ʵ�ָ������� doExercise2()���˷������߳��������һ��ʱ�䡣
		private void doExercise2() {
			try {
				long duration = (long) (Math.random() * 10);
				TimeUnit.SECONDS.sleep(duration);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// 16. ʵ�ָ������� doExercise3()���˷������߳��������һ��ʱ�䡣
		private void doExercise3() {
			try {
				long duration = (long) (Math.random() * 10);
				TimeUnit.SECONDS.sleep(duration);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
