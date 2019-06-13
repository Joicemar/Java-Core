package com.br.ZZEconcorrencia.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class CallableTest implements Callable<String> {

	@Override
	public String call() throws Exception {
		/*
		 * A diferen�a para o Math.random � que este pega o random pela thread que est�
		 * ativa no momento evitando assim a concorr�ncia entre Threads
		 */
		int count = ThreadLocalRandom.current().nextInt(1, 11);
		for (int i = 0; i < count; i++) {
			System.out.println(Thread.currentThread().getName() + " Executando...");
		}
		return "Trabalho finalizado, o n�mero aleat�rio � " + count;

	}

	public static void main(String[] args) {
	
		CallableTest caltest = new CallableTest();
		ExecutorService ex = Executors.newCachedThreadPool();
		
	}
	
	
}
