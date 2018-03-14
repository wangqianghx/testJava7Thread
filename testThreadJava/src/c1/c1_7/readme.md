# 线程管理（六）等待线程的终结

## 等待线程的终结

> 在某些情况下，我们需要等待线程的终结。例如，我们可能会遇到程序在执行前需要初始化资源。在执行剩下的代码之前，我们需要等待线程完成初始化任务。

> 为达此目的, 我们使用Thread 类的join() 方法。当前线程调用某个线程的这个方法时，它会暂停当前线程，直到被调用线程执行完成。

> 在这个指南中, 我们将学习用初始化例子来使用这个方法。

## 准备

> 指南中的例子是使用Eclipse IDE 来实现的。如果你使用Eclipse 或者其他的IDE，例如NetBeans, 打开并创建一个新的java项目。

## 怎么做呢…

> c1_7

* 查看顺序
* DataSourcesLoader
* NetworkConnectionsLoader
* Main

## 它是怎么工作的…

> 当你运行这个程序时，你可以发现2个线程对象都开始他们的执行。首先， DataSourcesLoader 结束它的运行。然后， NetworkConnectionsLoader 类结束它的运行，同时，主线程对象继续运行并写下了最后的信息。

## 更多

> Java 提供2种形式的 join() 方法:<br>
join (long milliseconds)<br>
join (long milliseconds, long nanos)<br>
第一种join() 方法, 这方法让调用线程等待特定的毫秒数。例如，如果thread1对象使用代码thread2.join(1000), 那么线程 thread1暂停运行，直到以下其中一个条件发生：<br>
thread2 结束运行<br>
1000 毫秒过去了<br>
当其中一个条件为真时，join() 方法返回。<br>
第二个版本的 join() 方法和第一个很像，只不过它接收一个毫秒数和一个纳秒数作为参数。