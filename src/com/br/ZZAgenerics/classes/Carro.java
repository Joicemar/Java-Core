package com.br.ZZAgenerics.classes;

public class Carro {
	
	String nome;


	public Carro(String nome) {
		super();
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "Carro [nome: " + nome + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
