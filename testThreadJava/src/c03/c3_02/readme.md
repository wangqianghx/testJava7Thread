# test

# �߳�ͬ�����ߣ�һ�����Ʋ���������Դ

## ���Ʋ���������Դ

> ���ָ�ϣ��㽫ѧϰ����ʹ��Java�����ṩ��Semaphore���ơ�Semaphore��һ�����Ʒ��ʶ��������Դ�ļ�������

> Semaphore����������Edsger Dijkstra���벢�� THEOS����ϵͳ�ϵ�һ��ʹ�á�

> ��һ���߳���Ҫ����ĳ��������Դ�����ȣ���������semaphore�����semaphore���ڲ���������ֵ����0����ôsemaphore���ټ�������ֵ���������ʹ�������Դ����������ֵ����0��ʾ���п�������ʹ�õ���Դ�������߳̿��Է��ʲ�ʹ�����ǡ�

> ��һ����������semaphore�ļ�������ֵ����0����ôsemaphore���߳̽�������״̬һֱ������������0����������ֵ����0��ʾȫ���Ĺ�����Դ�������߳���ʹ�ã����Դ��߳���Ҫ���ʾͱ���ȵ�ĳ����Դ��Ϊ���ɵġ�

> ���߳�ʹ���깲����Դʱ��������ų�semaphoreΪ���������߳̿��Է��ʹ�����Դ���������������semaphore���ڲ���������ֵ��

> �����ָ����㽫ѧϰ���ʹ��Semaphore����ʵ��һ�ֱȽ������semaphores���࣬��Ϊbinary semaphores�����semaphores���ౣ�����ʹ�����Դ�Ķ����ԣ�����semaphore���ڲ���������ֵֻ����1����0��Ϊ��չʾ���ʹ�������㽫Ҫʵ��һ��PrintQueue�����ò��������ӡ���ǵ��������PrintQueue����ܵ�binary semaphore�ı���������ÿ��ֻ����һ���߳̿��Դ�ӡ��

## ׼��

> ָ���е�������ʹ��Eclipse IDE ��ʵ�ֵġ������ʹ��Eclipse ����������IDE������NetBeans, �򿪲�����һ���µ�java����

## ��ô���ء�

## ������ô�����ġ�

> ������ӵĹؼ���PrintQueue���printJob()�������˷���չʾ��3����������صĲ��赱��ʹ��semaphore��ʵ��critical sectionʱ��������������Դ�ķ��ʣ�

1. ���ȣ� ��Ҫ����acquire()�������semaphore��
2. Ȼ�� �Թ�����Դ������Ҫ�Ĳ�����
3. ��� ����release()�������ͷ�semaphore��

> ��һ���ص���PrintQueue��Ĺ��췽���ͳ�ʼ��Semaphore�����㴫��ֵ1��Ϊ�˹��췽���Ĳ�������ô��ʹ�����һ��binary semaphore����ʼֵΪ1���ͱ����˷���һ��������Դ������������print queue��

> ���㿪ʼ10��threads�����㿪ʼ10��threadsʱ����ô��һ�����semaphore�ĵõ�critical section�ķ���Ȩ��ʣ�µ��̶߳��ᱻsemaphore����ֱ���Ǹ����semaphore���߳��ͷ������������������semaphore�ڵȴ����߳���ѡ��һ��������������critical section�ķ���Ȩ��ȫ�������񶼻��ӡ�ĵ���ֻ��һ����һ����ִ�С�

## ���࡭

> Semaphore������2���汾�� acquire() ������

> acquireUninterruptibly()��acquire()�����ǵ�semaphore���ڲ���������ֵΪ0ʱ�������߳�ֱ��semaphore���ͷš��������ڼ䣬�߳̿��ܻᱻ�жϣ�Ȼ��˷����׳�InterruptedException�쳣�����˰汾��acquire����������̵߳��ж϶��Ҳ����׳��κ��쳣��
tryAcquire()���˷����᳢�Ի�ȡsemaphore������ɹ�������true��������ɹ�������falseֵ�������ᱻ�����͵ȴ�semaphore���ͷš�����������������÷��ص�ִֵ����ȷ���ж���
Semaphores�Ĺ�ƽ��

> fairness��������ָȫjava���Ե��������У���Щ������������̲߳��ȴ�ͬ����Դ�ͷŵ��ࣨ���磬semaphore)��Ĭ��������Ƿǹ�ƽģʽ�������ģʽ�У���ͬ����Դ�ͷţ��ͻ�ӵȴ����߳�������ѡ��һ�������Դ����������ѡ��û���κα�׼������ƽģʽ���Ըı������Ϊ��ǿ��ѡ��ȴ����ʱ����̡߳�

> ����������ĳ��֣�Semaphore��Ĺ��캯�������ڶ���������������������� Boolean ֵ������������ false ֵ����ô������semaphore�ͻ��ڷǹ�ƽģʽ�����С�����㲻ʹ������������Ǹ���falseֵһ���Ľ��������������trueֵ����ô�㴴����semaphore�ͻ��ڹ�ƽģʽ�����С�

## �μ�

> �ڰ��£����Բ���Ӧ�ã�Lock�ӿڵļ��

> �ڶ��£������߳�ͬ�����޸�lock�Ĺ�ƽ��