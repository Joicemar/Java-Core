package com.pessoa;

import java.util.ArrayList;
import java.util.List;

public class Registrar implements Data {

	public static List<Pessoa> listaPessoas;
	
	public Registrar() {
		listaPessoas = new ArrayList<Pessoa>();

	}

	void listar() {
		for(Pessoa ps: listaPessoas) {
			System.out.println(ps.toString());
		}
	}
	@Override
	public void save() {

	}

	@Override
	public void load() {

	}
}
