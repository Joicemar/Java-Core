package com.br.ZZAgenerics.classes;

import java.util.ArrayList;
import java.util.List;

public class ClasseGenerica {
	public static void main(String[] args) {
		List<Carro> carrosDisponiveis = new ArrayList<>();
		carrosDisponiveis.add(new Carro("BMW"));
		carrosDisponiveis.add(new Carro("FUSCA"));
		ObjetosAlugaveis<Carro> carros = new ObjetosAlugaveis<>(carrosDisponiveis); 
		Carro carroAlugado = carros.getObjetoDisponivel();
		System.out.println("Alugando: "+carroAlugado);
		carros.devolverObjeto(carroAlugado);
		
		System.out.println("-------------------------");
		List<Computador> computadorDisponiveis = new ArrayList<>();
		computadorDisponiveis.add(new Computador("ACER"));
		computadorDisponiveis.add(new Computador("DELL"));
		ObjetosAlugaveis<Computador> computador = new ObjetosAlugaveis<>(computadorDisponiveis); 
		Computador pc = computador.getObjetoDisponivel();
		System.out.println("Alugando: "+pc);
		computador.devolverObjeto(pc);
	}

}

// t = typo
// e = elemento
class ObjetosAlugaveis<T>{
	private List<T> objetosDisponiveis;
	
	public ObjetosAlugaveis(List<T> objetosDisponiveis) {
		this.objetosDisponiveis = objetosDisponiveis;
	}
	
	public T getObjetoDisponivel() {
		T t = objetosDisponiveis.remove(0);
		System.out.println("Alugando objeto "+ t);
		System.out.println("Objetos disponiveis "+ objetosDisponiveis);
		return t;
	}
	
	public void devolverObjeto(T t) {
		System.out.println("Devolvendo objeto "+t);
		objetosDisponiveis.add(t);
		
		
	}
}
