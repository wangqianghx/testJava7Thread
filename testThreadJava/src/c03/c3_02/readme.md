# test

# 线程同步工具（一）控制并发访问资源

## 控制并发访问资源

> 这个指南，你将学习怎样使用Java语言提供的Semaphore机制。Semaphore是一个控制访问多个共享资源的计数器。

> Semaphore的内容是由Edsger Dijkstra引入并在 THEOS操作系统上第一次使用。

> 当一个线程想要访问某个共享资源，首先，它必须获得semaphore。如果semaphore的内部计数器的值大于0，那么semaphore减少计数器的值并允许访问共享的资源。计数器的值大于0表示，有可以自由使用的资源，所以线程可以访问并使用它们。

> 另一种情况，如果semaphore的计数器的值等于0，那么semaphore让线程进入休眠状态一直到计数器大于0。计数器的值等于0表示全部的共享资源都正被线程们使用，所以此线程想要访问就必须等到某个资源成为自由的。

> 当线程使用完共享资源时，他必须放出semaphore为了让其他线程可以访问共享资源。这个操作会增加semaphore的内部计数器的值。

> 在这个指南里，你将学习如何使用Semaphore类来实现一种比较特殊的semaphores种类，称为binary semaphores。这个semaphores种类保护访问共享资源的独特性，所以semaphore的内部计数器的值只能是1或者0。为了展示如何使用它，你将要实现一个PrintQueue类来让并发任务打印它们的任务。这个PrintQueue类会受到binary semaphore的保护，所以每次只能有一个线程可以打印。

## 准备

> 指南中的例子是使用Eclipse IDE 来实现的。如果你使用Eclipse 或者其他的IDE，例如NetBeans, 打开并创建一个新的java任务。

## 怎么做呢…

## 它是怎么工作的…

> 这个例子的关键是PrintQueue类的printJob()方法。此方法展示了3个你必须遵守的步骤当你使用semaphore来实现critical section时，并保护共享资源的访问：

1. 首先， 你要调用acquire()方法获得semaphore。
2. 然后， 对共享资源做出必要的操作。
3. 最后， 调用release()方法来释放semaphore。

> 另一个重点是PrintQueue类的构造方法和初始化Semaphore对象。你传递值1作为此构造方法的参数，那么你就创建了一个binary semaphore。初始值为1，就保护了访问一个共享资源，在例子中是print queue。

> 当你开始10个threads，当你开始10个threads时，那么第一个获得semaphore的得到critical section的访问权。剩下的线程都会被semaphore阻塞直到那个获得semaphore的线程释放它。当这情况发生，semaphore在等待的线程中选择一个并给予它访问critical section的访问权。全部的任务都会打印文档，只是一个接一个的执行。

## 更多…

> Semaphore类有另2个版本的 acquire() 方法：

> acquireUninterruptibly()：acquire()方法是当semaphore的内部计数器的值为0时，阻塞线程直到semaphore被释放。在阻塞期间，线程可能会被中断，然后此方法抛出InterruptedException异常。而此版本的acquire方法会忽略线程的中断而且不会抛出任何异常。
tryAcquire()：此方法会尝试获取semaphore。如果成功，返回true。如果不成功，返回false值，并不会被阻塞和等待semaphore的释放。接下来是你的任务用返回的值执行正确的行动。
Semaphores的公平性

> fairness的内容是指全java语言的所有类中，那些可以阻塞多个线程并等待同步资源释放的类（例如，semaphore)。默认情况下是非公平模式。在这个模式中，当同步资源释放，就会从等待的线程中任意选择一个获得资源，但是这种选择没有任何标准。而公平模式可以改变这个行为并强制选择等待最久时间的线程。

> 随着其他类的出现，Semaphore类的构造函数容许第二个参数。这个参数必需是 Boolean 值。如果你给的是 false 值，那么创建的semaphore就会在非公平模式下运行。如果你不使用这个参数，是跟给false值一样的结果。如果你给的是true值，那么你创建的semaphore就会在公平模式下运行。

## 参见

> 第八章，测试并发应用：Lock接口的监控

> 第二章，基本线程同步：修改lock的公平性