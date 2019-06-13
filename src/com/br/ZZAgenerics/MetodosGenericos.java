package com.br.ZZAgenerics;

import java.util.ArrayList;
import java.util.List;

import com.br.ZZAgenerics.classes.Computador;

public class MetodosGenericos {
	public static void main(String[] args) {
		criarArray(new Computador("Dell"));
	}
	
	public static <T> void criarArray(T t){
		List<T> lista = new ArrayList<>();
		lista.add(t);
		System.out.println(lista);
	}

	public static <T extends Animal> void criarArray2(T t){
		List<T> lista = new ArrayList<>();
		lista.add(t);
		System.out.println(lista);
	}

}
