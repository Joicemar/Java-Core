package com.br.ZZDthreads.test;
//Daemon & User
class ThreadExemplo extends Thread {

	private char c;

	public ThreadExemplo(char c) {
		this.c = c;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		for (int i = 0; i < 1000; i++) {
			System.out.println(c);
			if (i % 100 == 0) {
				System.out.println();
			}
		}
	}
}

class ThreadExemploRunnable implements Runnable {

	private char c;

	public ThreadExemploRunnable(char c) {
		this.c = c;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		for (int i = 0; i < 1000; i++) {
			System.out.println(c);
			if (i % 100 == 0) {
				System.out.println();
			}
			if(!Thread.currentThread().getName().equals("T4")) {
				Thread.yield();
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}

public class ThreadTest {

	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().getName());
//		ThreadExemplo t1 = new ThreadExemplo('A');
//		ThreadExemplo t2 = new ThreadExemplo('B');
//		ThreadExemplo t3 = new ThreadExemplo('C');
//		ThreadExemplo t4 = new ThreadExemplo('D'); 
		Thread t1 = new Thread(new ThreadExemploRunnable('A'));
		Thread t2 = new Thread(new ThreadExemploRunnable('B'));
		Thread t3 = new Thread(new ThreadExemploRunnable('C'));
		Thread t4 = new Thread(new ThreadExemploRunnable('D'));
		t1.start();
		t1.join();
		t2.start();
		t3.start();
		t4.start();		
		
		
	}


}
