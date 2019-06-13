package com.br.modificadorEstatico;

public class Cliente {
	// 1 - Bloco de inicializa??o statico ? executado quando a JVM carregar a classe (o bloco ? executado apenas 1 vez)
	// 2 - Alocado espa?o na mem?ria para o objeto que ser? criado
	// 3 - Cada atributo da classe ? criado e inicializado com seus valores default ou valores e expl?citos]
	// 4 - Bloco de inicializa??o ? executado.
	// 5 - O contrutor ? executado.
	private static int[] parcelas;

	
	{
		System.out.println("Bloco normal");
	}
	
	static{
		parcelas = new int[100];
		System.out.println("Dentro do bloco de inicializa??o");
		for(int i=1; i<=100; i++) {
			parcelas[i-1] = i;
		}
	}
	static {
		System.out.println("Bloco de inicializa??o 2");
	}
	
	
	public Cliente() {
	}

	public static int[] getParcelas() {
		return parcelas;
	}
	

}
