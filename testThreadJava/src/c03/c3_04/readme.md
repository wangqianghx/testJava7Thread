# 线程同步工具（三）等待多个并发事件完成

## 等待多个并发事件完成

> Java并发API提供这样的类，它允许1个或者多个线程一直等待，直到一组操作执行完成。 这个类就是CountDownLatch类。它初始一个整数值，此值是线程将要等待的操作数。当某个线程为了想要执行这些操作而等待时， 它要使用 await()方法。此方法让线程进入休眠直到操作完成。 当某个操作结束，它使用countDown() 方法来减少CountDownLatch类的内部计数器。当计数器到达0时，这个类会唤醒全部使用await() 方法休眠的线程们。

> 在这个指南，你将学习如果使用 CountDownLatch 类来实现 video- conference 系统。 video-conference 系统将等待全部参与者到达后才会开始。

## 准备

> 指南中的例子是使用Eclipse IDE 来实现的。如果你使用Eclipse 或者其他的IDE，例如NetBeans，打开并创建一个新的java任务。

## 怎么做呢…


## 它是怎么工作的…

> CountDownLatch类有3个基本元素：

>初始值决定CountDownLatch类需要等待的事件的数量。

> await() 方法, 被等待全部事件终结的线程调用。
>countDown() 方法，事件在结束执行后调用。
>当创建 CountDownLatch 对象时，对象使用构造函数的参数来初始化内部计数器。每次调用 countDown() 方法, CountDownLatch 对象内部计数器减一。当内部计数器达到0时， CountDownLatch 对象唤醒全部使用 await() 方法睡眠的线程们。

>不可能重新初始化或者修改CountDownLatch对象的内部计数器的值。一旦计数器的值初始后，唯一可以修改它的方法就是之前用的 countDown() 方法。当计数器到达0时， 全部调用 await() 方法会立刻返回，接下来任何countDown() 方法的调用都将不会造成任何影响。

>此方法与其他同步方法有这些不同：

>CountDownLatch 机制不是用来保护共享资源或者临界区。它是用来同步一个或者多个执行多个任务的线程。它只能使用一次。像之前解说的，一旦CountDownLatch的计数器到达0，任何对它的方法的调用都是无效的。如果你想再次同步，你必须创建新的对象。

>你可以发现最后的参与者到达后，内部计数器一到达0，CountDownLatch对象就叫醒全部的 Videoconference 对象，他们全部输出信息表示video conference可以开始了。

## 更多…

> CountDownLatch 类有另一种版本的 await() 方法，它是：

> await(long time, TimeUnit unit): 此方法会休眠直到被中断； CountDownLatch 内部计数器到达0或者特定的时间过去了。TimeUnit 类包含了:DAYS, HOURS, MICROSECONDS, MILLISECONDS, MINUTES, NANOSECONDS, 和 SECONDS.