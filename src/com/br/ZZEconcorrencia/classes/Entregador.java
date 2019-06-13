package com.br.ZZEconcorrencia.classes;

import com.br.ZZEconcorrencia.classes.ListaMembros;

public class Entregador implements Runnable {
	
	private ListaMembros listaMembros;
	
	public Entregador(ListaMembros listaMembros) {
		this.listaMembros = listaMembros;
	}

	@Override
	public void run() {
		String nomeThread = Thread.currentThread().getName();
		System.out.println(nomeThread + "Come�ando o trabalho de entrega.");
		int qtdPendente = listaMembros.getEmailDependentes();
		boolean aberta = listaMembros.isAberta();
		while(aberta || qtdPendente > 0) {
			try {
				String email = listaMembros.ObterEmailMembro();
				System.out.println(nomeThread+" enviando email para "+email);
				Thread.sleep(2000);
				System.out.println("Envio para "+email+" conclu�do com sucesso!");
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			aberta = listaMembros.isAberta();
			qtdPendente = listaMembros.getEmailDependentes();
		}
		System.out.println("Atividades Finalizadas");
		
	}
	
	
	

}
