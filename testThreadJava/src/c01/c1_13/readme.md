# 线程管理（十二）用线程工厂创建线程

## 用线程工厂创建线程

> 在面向对象编程的世界中，工厂模式是最有用的设计模式。它是一个创造模式，还有它的目的是创建一个或几个类的对象的对象。然后，当我们想创建这些类的对象时，我们使用工厂来代替new操作。

> 有了这个工厂，我们有这些优势来集中创建对象们：

> 更简单的改变了类的对象创建或者说创建这些对象的方式。<br>
更简单的为了限制的资源限制了对象的创建。 例如， 我们只new一个此类型的对象。<br>
更简单的生成创建对象的统计数据。<br>
Java提供一个接口， ThreadFactory 接口实现一个线程对象工厂。 并发 API 使用线程工厂来创建线程的一些基本优势。

> 在这个指南中，我们将学习如何实现ThreadFactory 接口来创建Thread 对象，当我们储存创建的线程对象时，可以取个性化的名字。

## 准备

> 指南中的例子是使用Eclipse IDE 来实现的。如果你使用Eclipse 或者其他的IDE，例如NetBeans, 打开并创建一个新的java项目。

## 怎么做呢…

## 它是怎么工作的…

> ThreadFactory 接口只有一个方法是 newThread。它接收 Runnable 对象作为参数并返回一个 Thread 对象。当你实现一个 ThreadFactory 接口，你必须实现此接口并覆盖这个方法。最基本的 ThreadFactory只有一行。
1
return new Thread(r);
你可以加一些变量来提升这个实现：

> 在这个例子中创建自定义线程，名字使用特别形式或者继承Java Thread类来创建自己的Thread类。
保存线程创建数据，如之前的例子。
限制线程创建个数。
验证线程的创建。
和你能想到的任何东西。
使用工厂设计模式是很好的练习，但是，如果你实现一个 ThreadFactory 接口来集中创建线程，那么你必须再检查代码确保使用的线程都是用这个工厂创建的。

##　参见

> 第七章: 并发类的定制：实现ThreadFactory接口来生成自定义线程

> 第七章: 并发类的定制：在执行者对象中使用我们的 ThreadFactory