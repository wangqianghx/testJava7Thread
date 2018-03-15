package c2.c2_6;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// ����PricesInfo�࣬�������洢������Ʒ�۸����Ϣ��
public class PricesInfo {
	
	// ��������double���͵����ԣ��ֱ�����Ϊprice1��price2��
	private double price1;
	private double price2;
	// ����һ����Ϊlock��ReadWriteLock����
	private ReadWriteLock lock;

	// ʵ����Ĺ���������ʼ�����������ԡ����У�����lock���ԣ����Ǵ���һ���µ�ReentrantReadWriteLock����
	public PricesInfo() {
		price1 = 1.0;
		price2 = 2.0;
		lock = new ReentrantReadWriteLock();
	}

	// ʵ��getPrice1()����������������price1���Ե�ֵ����ʹ�ö����������������ֵ�ķ��ʡ�
	public double getPrice1() {
		lock.readLock().lock();
		double value = price1;
		lock.readLock().unlock();
		return value;
	}

	// ʵ��getPrice2()����������������price2���Ե�ֵ����ʹ�ö����������������ֵ�ķ��ʡ�
	public double getPrice2() {
		lock.readLock().lock();
		double value = price2;
		lock.readLock().unlock();
		return value;
	}

	// ʵ��setPrices()�����������������������Ե�ֵ����ʹ��д�������ƶ����ǵķ��ʡ�
	public void setPrices(double price1, double price2) {
		lock.writeLock().lock();
		this.price1 = price1;
		this.price2 = price2;
		lock.writeLock().unlock();
	}
}
