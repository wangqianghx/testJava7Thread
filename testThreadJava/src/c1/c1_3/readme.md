# 线程管理（二）获取和设置线程信息

# 获取和设置线程信息

> Thread类的对象中保存了一些属性信息能够帮助我们来辨别每一个线程，知道它的状态，调整控制其优先级。 这些属性是：

> ID: 每个线程的独特标识。

> Name: 线程的名称。

> Priority: 线程对象的优先级。优先级别在1-10之间，1是最低级，10是最高级。不建议改变它们的优先级，但是你想的话也是可以的。

> Status: 线程的状态。在Java中，线程只能有这6种中的一种状态： new, runnable, blocked, waiting, time waiting, 或 terminated.

> 在这个指南里，我们将开发一个为10个线程设置名字和优先级的程序，然后展示它们的状态信息直到线程结束。这些线程会计算数字乘法表。

## 准备

> 指南中的例子是使用Eclipse IDE 来实现的。如果你使用Eclipse 或者其他的IDE，例如NetBeans, 打开并创建一个新的java项目。

## 怎么做呢…

> c1_3

* 查看顺序
* Calculator
* CalculatorMain2

## 它是如何工作的…

> 程序的控制台显示的是线程计算的乘法表，而log.txt文本记录的是不同线程的状态演变。这样子，可以更好的观察线程的演变过程。

> Thread 类有能保存使用线程信息的属性。JVM根据线程的优先级来选择将使用CPU的线程，然后再根据每个线程的情况来实现它们的状态。

> 如果你没有声明一个线程的名字，那么JVM会自动命名它为：Thread-XX，XX是一个数字。线程的ID或者状态是不可修改的。Thread类没有实现setId()和setStatus()方法来允许修改它们。

## 更多…

> 在这个指南中，你学习了如何使用Thread对象来访问线程的属性信息。你也可以实现Runnable接口来访问这些信息。你可以用Thread类的静态方法currentThread()来访问正在运行的Runnable 对象的 Thread对象。

> 你必须知道 setPriority() 方法会抛出 IllegalArgumentException 异常，如果你设置的优先级不是在1-10之间。