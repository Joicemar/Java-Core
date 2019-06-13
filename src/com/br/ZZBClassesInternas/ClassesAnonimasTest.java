package com.br.ZZBClassesInternas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.br.ZZAgenerics.classes.Carro;

class Animal{
	public void andar() {System.out.println("Andando");}
}

public class ClassesAnonimasTest {
	public static void main(String[] args) {
		
		Animal animal = new Animal() {
			public void andar() {
				System.out.println("Andando agora");
		}
			public void comer() {
				System.out.println("Comendo");
			}

		};
		animal.andar();
		
		List<Carro> carrosList = new ArrayList<>();
		carrosList.add(new Carro("BMW"));
		carrosList.add(new Carro("UNO"));
		carrosList.add(new Carro("UNO"));
		//Metodos anonimos, podemos sobrescrever interfaces em metodos anonimos
		Collections.sort(carrosList, new Comparator<Carro>(){

			@Override
			public int compare(Carro o1, Carro o2) {
				return o1.getNome().compareTo(o2.getNome());
			}
			
		});
		System.out.println(carrosList);
	}
}









