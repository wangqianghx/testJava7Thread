# �����߳�ͬ�����ˣ���Lock��ʹ�ö������

## ��Lock��ʹ�ö������

> һ�������ܰ����Ŷ����������Щ����������Condition�ӿ��С� ��Щ������Ŀ���������߳�ӵ�����Ŀ��Ʋ��Ҽ�������Ƿ�Ϊtrue�������false����ô�߳̽���������ֱ�������̻߳������ǡ�Condition�ӿ��ṩһ�ֻ��ƣ�����һ���̺߳ͻ���һ�����������̡߳�

> �ڲ�������У����������������Ǿ�������⡣������һ�����ݻ�������һ�������������������������洢���ݣ�һ���������������ߴӻ�������ȡ�����ݣ���������һ����ǰ�������͵�һ����

> �����ָ���У��㽫ѧϰ���ͨ��ʹ������������ʵ�������������������⡣

## ׼��������

��Ӧ�������Ķ�ʹ��Lockͬ�������ָ�ϣ����ܸ��õ��������ʳ�ס�

## �������

## ������ι����ġ�

> �� ��Condition���������йأ�����ʹ��������Lock�ӿ��е�newCondition()������������ʹ��condition���κβ���֮ǰ�� ������ȡ�����condition��ص����Ŀ��ơ����ԣ�condition�Ĳ���һ�������Ե���Lock�����lock()����Ϊ��ͷ���Ե�����ͬ Lock�����unlock()����Ϊ��β�Ĵ�����С�

> ��һ���߳���һ��condition�ϵ���await()����ʱ�������Զ��ͷ����Ŀ��ƣ����������߳̿��Ի�ȡ������Ŀ��Ʋ���ʼִ����ͬ������������ͬ���������������ٽ�����

> ע�ͣ���һ���߳���һ��condition�ϵ���signal()��signallAll()������һ������ȫ�������condition�ϵȴ����߳̽������ѡ��Ⲣ���ܱ�֤��ʹ��������˯�ߵ�����������true�������������whileѭ���ڲ�����await()�������㲻���뿪���ѭ����ֱ�� conditionΪtrue����conditionΪfalse��������ٴε��� await()������

> �����ʮ��С�� ����ʹ��await()��signal()����ʱ���������condition�ϵ���await()������ȴû�������condition�ϵ���signal()����������߳̽���Զ˯����ȥ��

> �ڵ���await()������һ���߳̿��Ա��жϵģ����Ե�������˯��ʱ������봦��InterruptedException�쳣��

## ��ֹ��Щ��

> Condition�ӿ��ṩ��ͬ�汾��await()���������£�

> await(long time, TimeUnit unit):����߳̽���һֱ˯��ֱ����<br>
(1)�����ж�<br>
(2)�����߳������condition�ϵ���singal()��signalAll()����<br>
(3)ָ����ʱ���Ѿ�����<br>
(4)TimeUnit����һ��ö���������µĳ�����DAYS,HOURS, MICROSECONDS, MILLISECONDS, MINUTES, NANOSECONDS,SECONDS

> awaitUninterruptibly():����߳̽����ᱻ�жϣ�һֱ˯��ֱ�������̵߳���signal()��signalAll()����
awaitUntil(Date date):����߳̽���һֱ˯��ֱ����<br>
(1)�����ж�<br>
(2)�����߳������condition�ϵ���singal()��signalAll()����<br>
(3)ָ���������Ѿ�����<br>
�������һ����/д���е�ReadLock��WriteLock��ʹ��conditions��

## �μ�

> �ڵ�2�£������߳�ͬ����ʹ��Lockͬ��������ָ��

> �ڵ�2�£������߳�ͬ����ʹ�ö�/д��ͬ�����ݷ���