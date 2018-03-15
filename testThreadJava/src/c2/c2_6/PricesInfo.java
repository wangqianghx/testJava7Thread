package c2.c2_6;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// 创建PricesInfo类，用它来存储两个产品价格的信息。
public class PricesInfo {
	
	// 声明两个double类型的属性，分别命名为price1和price2。
	private double price1;
	private double price2;
	// 声明一个名为lock的ReadWriteLock对象。
	private ReadWriteLock lock;

	// 实现类的构造器，初始化这三个属性。其中，对于lock属性，我们创建一个新的ReentrantReadWriteLock对象。
	public PricesInfo() {
		price1 = 1.0;
		price2 = 2.0;
		lock = new ReentrantReadWriteLock();
	}

	// 实现getPrice1()方法，用它来返回price1属性的值。它使用读锁来控制这个属性值的访问。
	public double getPrice1() {
		lock.readLock().lock();
		double value = price1;
		lock.readLock().unlock();
		return value;
	}

	// 实现getPrice2()方法，用它来返回price2属性的值。它使用读锁来控制这个属性值的访问。
	public double getPrice2() {
		lock.readLock().lock();
		double value = price2;
		lock.readLock().unlock();
		return value;
	}

	// 实现setPrices()方法，用来建立这两个属性的值。它使用写锁来控制对它们的访问。
	public void setPrices(double price1, double price2) {
		lock.writeLock().lock();
		this.price1 = price1;
		this.price2 = price2;
		lock.writeLock().unlock();
	}
}
