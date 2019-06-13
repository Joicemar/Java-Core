package com.br.ZZEconcorrencia.classes;

import javax.swing.JOptionPane;

import com.br.ZZDthreads.classes.Entregador;
import com.br.ZZEconcorrencia.classes.ListaMembros;

public class EntregadorTest {
	
	public static void main(String[] args) {
		ListaMembros membros = new ListaMembros();
		Thread t1 = new Thread(new Entregador(membros), "Entregador 1");
		Thread t2 = new Thread(new Entregador(membros), "Entregador 2");
		t1.start();
		t2.start();
		while(true) {
			String email = JOptionPane.showInputDialog("Digite o email do membro");
			if(email == null || email.isEmpty()) {
				membros.fecharLista();
				break;
			}
			membros.adicionarMembroEmail(email);
		}
	}

}
