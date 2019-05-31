package com.br.blocodeinicializacao.classes;

public class ClienteTeste {
	public static void main(String[] args) {
		
		Cliente c = new Cliente();
		
		for(int parcela : c.getParcelas()) {
			System.out.print(parcela + " ");
		}
	}
}
