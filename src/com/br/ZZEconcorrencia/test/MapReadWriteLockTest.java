package com.br.ZZEconcorrencia.test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MapReadWrite{
	private Map<String, String> map = new LinkedHashMap<>();
	
	public void put(String key, String value) {
		map.put(key, value);
	}
	
	public Object[] allJeys() {
		return map.keySet().toArray();
	}
	
}

public class MapReadWriteLockTest {
	/*ReentrantReadWriteLock Esta classe trabalha com um par de locks, tanto para leitura quanto
	 *  para escrita. Para escrita só uma thread pode segurar o lock por vez, mas para escrita 
	 *  mais de um thread pode segurar  aquele lock*/
	private final static MapReadWrite readWrite = new MapReadWrite();
	private static final ReentrantReadWriteLock rvl = new ReentrantReadWriteLock();
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Write());
		Thread t2 = new Thread(new ReadA());
		Thread t3 = new Thread(new ReadB());
		t1.start();
		t2.start();
		t3.start();
		
	}
	
	static class Write implements Runnable{

		@Override
		public void run() {
			for(int i = 0; i < 100; i++) {
				/*tanto writeLock() como readLock() retornam um lock, um para leitura e outra para escrita*/
//				Lock lock = rvl.writeLock();
				rvl.writeLock().lock();;
				
				try {
					readWrite.put(String.valueOf(i), String.valueOf(i));
				}finally {
					/*que deverá ser encerrado*/
					rvl.writeLock().unlock();
				}
			}
		}
		
	}
	
	static class ReadA implements Runnable{

		@Override
		public void run() {
			for ( int i = 0; i < 10; i++) {
				rvl.readLock().lock();
				try {
					System.out.println(Thread.currentThread().getName() +" "+Arrays.toString(readWrite.allJeys()));
					
				}finally {
					rvl.readLock().unlock();
				}
			}
			
		}
		
		
	}
	
	static class ReadB implements Runnable{

		@Override
		public void run() {
			for ( int i = 0; i < 10; i++) {
				rvl.readLock().lock();
				try {
					System.out.println(Thread.currentThread().getName() +" "+Arrays.toString(readWrite.allJeys()));
					
				}finally {
					rvl.readLock().unlock();
				}
			}
			
		}
		
		
	}
	
}





