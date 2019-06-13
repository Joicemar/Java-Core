package com.br.ZZEconcorrencia.test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Contador {
	
	public int count;
	private AtomicInteger atomicInteger = new AtomicInteger();
	private Lock lock = new ReentrantLock();
	
	public void increment() {
		lock.lock();
		try {
		count++;
		atomicInteger.getAndDecrement();
		}finally{
			lock.unlock();
		}
		
	}
	
	public int getCount() {
		return count;
	}
	
	public int getAtomicInteger() {
		return atomicInteger.intValue();
		
	}
	
}

class IncrementadorThread extends Thread{
	private Contador contador;
	
	public IncrementadorThread(Contador contador) {
		this.contador = contador;
	}
	
	public void run() {
		for(int i = 0; i < 1000; i++) {
			contador.increment();
		}
	}
	
}

public class ConcorrenciaTest {
	public static void main(String[] args) throws InterruptedException {
		Contador c = new Contador();
		IncrementadorThread t1 = new IncrementadorThread(c);
		IncrementadorThread t2 = new IncrementadorThread(c);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(c.getCount());
		System.out.println(c.getAtomicInteger());
	}
}









