package com.br.ZZEconcorrencia.test;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

public class LinkedTransferQueueTest {
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("=====================");
		TransferQueue<String> tq = new LinkedTransferQueue<>();
		
		System.out.println(tq.add("Joicemar"));
		tq.put("joicemar");
		tq.offer("morais");
		System.out.println(tq.remainingCapacity());
		System.out.println(tq.offer("joao",0,TimeUnit.MILLISECONDS)); //Verifica se ele enseriu nesse tempo
		System.out.println(tq.offer("joao",1,TimeUnit.NANOSECONDS));
//		tq.transfer("DevDojo"); //transfer bloqueia ate´que outra thread remova o valor DevDojo
		 // tryTransfer: vai retornar true se for consumido por uma thread que estava esperando, ou
		// vai retornar false se nenhuma thread estiver esperando ou for consumido por outra
		System.out.println(tq.tryTransfer("DevDojo"));
//		System.out.println(tq.tryTransfer("DevDojo", 1 , TimeUnit.SECONDS)); // Vai esperar pelo tempo para ser consumido
		System.out.println("=======================");
		System.out.println(tq.remainingCapacity());
		System.out.println(tq.element()); // exibe os valores
		System.out.println(tq.peek()); // pegar o primeiro valor sem remover
		System.out.println(tq.poll()); // remove o primeiro valor
		System.out.println(tq.poll(10, TimeUnit.MICROSECONDS)); // remove o primeiro valor
		System.out.println(tq.remove()); // remove o primeiro valor
		System.out.println(tq.take()); // remove o primeiro valor ou bloqueia até tiver um elemento pronto
		
		
	}
}
