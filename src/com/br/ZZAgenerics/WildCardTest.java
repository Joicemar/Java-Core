package com.br.ZZAgenerics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract class Animal{

	public abstract void consulta();
	
}

class Cachorro extends Animal implements Comparable{

	@Override
	public void consulta() {
		System.out.println("Consultado chachorro");
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}
	
}

class Gato extends Animal{

	@Override
	public void consulta() {
		System.out.println("Consultando gato");
	}
	
}

public class WildCardTest {
	public static void main(String[] args) {
		
		Cachorro[] cachorros = {new Cachorro(), new Cachorro()};
		Gato[] gato = {new Gato(), new Gato()};
		
		List<Cachorro> cachorroList = new ArrayList<>();
		cachorroList.add(new Cachorro());
		List<Gato> gatoList = new ArrayList<>();
		gatoList.add(new Gato());
		
		consutarAnimaisList(cachorroList);
		consutarAnimaisList(gatoList);
		
	}

	private static void consutarAnimaisList(List< ? extends Animal> animals) {
		for(Animal animal: animals) {
			animal.consulta();
		}
		
	}
	
	public void consultarCachorroList(List< ? super Cachorro> cachorro) {
		Cachorro c1 = (new Cachorro());
		Animal c2 = new Cachorro();
		Object c3 = new Cachorro();
		cachorro.add(new Cachorro());
	}
	
	public static void ordenarLista(List< ? extends Comparable> lista) {
		Collections.sort(lista);
	}
}










