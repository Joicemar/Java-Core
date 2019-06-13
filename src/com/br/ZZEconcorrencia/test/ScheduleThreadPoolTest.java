package com.br.ZZEconcorrencia.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleThreadPoolTest {
	/*
	 * ScheduledExecutorService serve para fazer agendamento de execuções de tempo
	 * em tempo
	 */
	private static final ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
	private static final java.lang.Runnable Runnable = null;

	private static void beep() {
		final Runnable beeper = new Runnable() {
		
		@Override
		public void run(){
			System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date())+ "beep");
		}
	};
	//Métodos para executar uma tarefa Runnable de tempo em tempo
	ses.scheduleAtFixedRate(beeper, 1, 5, TimeUnit.SECONDS); // Este conta mesmo usando o sleep
	ses.scheduleWithFixedDelay(beeper, 1, 5, TimeUnit.SECONDS); // Começa a contar somente depois do sleep
	}
	
	public static void main(String[] args) {
		beep();
	}
	
//	private void beep() {
//		//Serve para executar uma tarefa de tempo em tempo, seja horas ou outra medida de tempo
//		ses.schedule(Runnable, 1, TimeUnit.SECONDS);
//	}

}
