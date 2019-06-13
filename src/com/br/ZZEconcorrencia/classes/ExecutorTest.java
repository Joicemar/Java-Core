package com.br.ZZEconcorrencia.classes;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ThreadTrabalhadoraTest implements Runnable{
	
	private String num;
	
	public ThreadTrabalhadoraTest(String num) {
		this.num = num;

	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+ " iniciou "+num);
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" finalizou");
	}

}

public class ExecutorTest {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		executorService.execute(new ThreadTrabalhadoraTest("1"));
		executorService.execute(new ThreadTrabalhadoraTest("2"));
		executorService.execute(new ThreadTrabalhadoraTest("3"));
		executorService.execute(new ThreadTrabalhadoraTest("4"));
		System.out.println("Finalizado");
		executorService.shutdown();

		while(!executorService.isTerminated()) {}
		
		System.out.println(executorService.isTerminated());
		System.out.println(Runtime.getRuntime().availableProcessors());
	}






}





