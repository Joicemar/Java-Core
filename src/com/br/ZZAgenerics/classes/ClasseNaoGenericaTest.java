package com.br.ZZAgenerics.classes;

import java.util.ArrayList;
import java.util.List;

public class ClasseNaoGenericaTest {
	public static void main(String[] args) {
		
		AlugaCarro carroAlugavel = new AlugaCarro();
		Carro carroAlugado = carroAlugavel.carroDisponivel();
		System.out.println("Carros alugados "+carroAlugado);
		carroAlugavel.devolverCarro(carroAlugado);
		
	}
	
}

class AlugaCarro{
	
	private List<Carro> carrosDisponiveis = new ArrayList();
	{
		carrosDisponiveis.add(new Carro("BMW"));
		carrosDisponiveis.add(new Carro("GOL"));
	}
	
	public Carro carroDisponivel() {
		Carro c = carrosDisponiveis.remove(0);
		System.out.println("Alugando Carros "+ c);
		System.out.println("Carros disponiveis "+ carrosDisponiveis);
		return c;
	}
	
	public void devolverCarro(Carro c) {
		carrosDisponiveis.add(c);
		System.out.println("Devolvendo carro "+c);
		
		
	}
	
}
class AlugaComputador{
	
	
}






