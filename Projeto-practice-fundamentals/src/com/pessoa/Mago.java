package com.pessoa;

public class Mago extends Pessoa{

	
	public Mago(String nome, int idade, Estado estado) {
		this.nome = nome;
		this.idade = idade;
		this.estado = estado;
	}
	
	public Mago() {
		this.nome = "Sem nome registrado";
		this.idade = 0;
		this.estado = Estado.NO_VIP;
	}

	@Override
	public String toString() {
	
		return "Nome: "+this.getNome()+
				"\nIdade: "+this.getIdade()+
				"\nEstado: "+this.getEstado()+"\n";
	}
}
