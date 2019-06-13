package com.br.ZZDthreads.test;

public class DeadLockTest {
	
	public static Object lock1 = new Object();
	public static Object lock2 = new Object();
	
	public static void main(String[] args) {
		new ThreadExemplo1().start();
		new ThreadExemplo2().start();
	}
	
	private static class ThreadExemplo1 extends Thread{
		public void run() {
			synchronized (lock1) {
				System.out.println("Thread 1: segurando o lock1");
				System.out.println("Thread 1: esperando pelo lock2");
				synchronized(lock2) {
					System.out.println("Thread 1: segurando o lock1 e lock2");
				}
			}
		}

	}
	//Consertado
	private static class ThreadExemplo2 extends Thread{
		public void run() {
			synchronized (lock1) {
				System.out.println("Thread 2: segurando o lock1");
				System.out.println("Thread 2: esperando pelo lock2");
				synchronized(lock2) {
					System.out.println("Thread 2: segurando o lock2 e lock1");
				}
			}
		}
		
	}

}
