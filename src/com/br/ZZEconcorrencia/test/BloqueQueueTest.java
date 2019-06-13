package com.br.ZZEconcorrencia.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class BloqueQueueTest {
	public static void main(String[] args) throws InterruptedException {
		
		BlockingQueue<String> bq = new ArrayBlockingQueue<>(1);
//		SynchronousQueue Essa classe ficara bloqueada quando vc modifica-la ate que outra Thread faça ela retornar ao valor
		Thread t1 = new Thread(new RemoveFromQueue(bq));
		
		bq.put("Joicemar");
		System.out.println(bq.peek());
		System.out.println("Tentando colocar outro valor");
		t1.start();
		bq.put("Morais");
		System.out.println("Inserido o último valor");
		
		
	}

	static class RemoveFromQueue implements Runnable{
		private BlockingQueue<String> bq;
		
		public RemoveFromQueue(BlockingQueue<String> bq) {
			this.bq = bq;
		}
		
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getId()+" entrando em espera por 2s");
			try {
				TimeUnit.SECONDS.sleep(2);
				System.out.println("Removendo o valor "+bq.take());
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
		}
		
	}
}

