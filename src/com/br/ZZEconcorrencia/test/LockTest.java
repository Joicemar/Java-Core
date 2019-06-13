package com.br.ZZEconcorrencia.test;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

	public static void main(String[] args) {
		final ReentrantLock lock = new ReentrantLock();
		new Thread(new Worker("A", lock)).start();
		new Thread(new Worker("B", lock)).start();
		new Thread(new Worker("C", lock)).start();
		new Thread(new Worker("D", lock)).start();
		new Thread(new Worker("E", lock)).start();
		new Thread(new Worker("F", lock)).start();
	}
	
	static class Worker implements Runnable{
		private String nome;
		private ReentrantLock lock;
		
		public Worker(String nome, ReentrantLock lock) {
			this.nome = nome;
			this.lock = lock;
		}

		@Override
		public void run() {
			lock.lock();
			try {
				if(lock.isHeldByCurrentThread()) {
					System.out.printf("Threat %s entrou numa sessão crítica%n",nome);
					System.out.printf("%d Thread esperando na fila%n",lock.getQueueLength());
					System.out.printf("Threat %s vai trabalhar por 2 segundos%n",nome);
					Thread.sleep(2000);
					System.out.printf("Threat %s finalizou o trabalho%n",nome);
				}
			}catch(InterruptedException e) {
				e.printStackTrace();
			}finally {
				lock.unlock();
			}
			
		}
		
	}
}
