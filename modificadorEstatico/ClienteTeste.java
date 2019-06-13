package com.br.modificadorEstatico;

public class ClienteTeste {
	public static void main(String[] args) {
		
		Cliente c = new Cliente();
		Cliente c1 = new Cliente();
		Cliente c2 = new Cliente();

		System.out.println("Exibindo quantidade de parcelas possíveis");
		for(int parcela : c.getParcelas()) {
			System.out.print(parcela + " ");
		}
		System.out.println("\nTamanho: " + Cliente.getParcelas().  length);
	}
}
