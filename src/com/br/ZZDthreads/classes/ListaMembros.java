package com.br.ZZDthreads.classes;

import java.util.LinkedList;
import java.util.Queue;

public class ListaMembros {
	
	private static Queue<String> emails = new LinkedList<>();
	public static boolean aberta = true;
	
	public int getEmailDependentes() {
		
		synchronized (emails) {
			return this.emails.size();
			
		}
	}
	
	public boolean isAberta() {
		return aberta;
	}
	
	public String ObterEmailMembro() {
		String email = null;
		try {
			synchronized(this.emails) {
				while(this.emails.size() == 0) {
					if(!aberta) return null;
					System.out.println("Lista vazia, Colocando a thread "+Thread.currentThread().getName()+" no modo wait");
					this.emails.wait();
				}
				email = this.emails.poll();
			}
			
		}catch( InterruptedException e ) {
			e.printStackTrace();
		}
		return email;
	}
	
	public static  void adicionarMembroEmail(String email) {
		synchronized(emails) {
			emails.add(email);
			System.out.println("Email adicionado na lista!");
			System.out.println("Email adicionado na lista!");
			emails.notifyAll(); // avisa todas as threads e faz com que os que estão em wait voltem ao estado runnable
			
		}
	}

	public static void fecharLista() {
		System.out.println("notificando todas as thread e fechando listas");
		
		
	}
}











