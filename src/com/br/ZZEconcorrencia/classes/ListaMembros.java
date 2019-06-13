package com.br.ZZEconcorrencia.classes;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ListaMembros {
	
	private final Queue<String> emails = new LinkedList<>();
	private final ReentrantLock lock = new ReentrantLock();
	private final Condition conditionLock = lock.newCondition();
	public boolean aberta = true;
	
	public int getEmailDependentes() {
		lock.lock();
		try {
			return this.emails.size();
		}finally {
			lock.unlock();
		}
	}
	
	public boolean isAberta() {
		return aberta;
	}
	
	public String ObterEmailMembro() {
		String email = null;
		try {
			lock.lock();
				while(this.emails.size() == 0) {
					if(!aberta) return null;
					System.out.println("Lista vazia, Colocando a thread "+Thread.currentThread().getName()+" no modo wait");
					conditionLock.await();
				}
				email = this.emails.poll();
			
		}catch( InterruptedException e ) {
			e.printStackTrace();
		}
		return email;
	}
	
	public void adicionarMembroEmail(String email) {
		lock.lock();
		try {
			emails.add(email);
			System.out.println("Email adicionado na lista!");
			System.out.println("Email adicionado na lista!");
			conditionLock.signalAll();
		}finally {
			lock.unlock();
		}
	}

	public void fecharLista() {
		lock.lock();
		try {
		this.emails.notifyAll();
		}finally {
			lock.unlock();
		}
		
	}
}











