package com.br.associacaoClasses;

public class Professor {
	public String nome;
	public String especialidade;
	public Seminario[] seminarios;
	
	
	public Professor() {
	}
	
	public Professor(String nome, String especialidade) {
		
		this.nome = nome;
		this.especialidade = especialidade;
		
	}
	
	public void print() {
		System.out.println("-------------------Especialidade do professor-------------------");
		System.out.println("Nome do professor: " + this.nome);
		System.out.println("Especialidade: " + this.especialidade);
		if (seminarios != null && seminarios.length != 0) {
			System.out.println("Seminarios participantes");
			for (Seminario sem : seminarios) {
				System.out.println(sem.getTitulo() + " ");
			}
			return;
		}
		System.out.println("Professor não vinculado a nenhum seminario");

		
	}
	
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	public String getEspecialidade() {
		
		return especialidade;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}

	public void setSeminario(Seminario[] seminarios) {
		this.seminarios = seminarios;
	}
	public Seminario[] getSeminario() {
		
		return seminarios;
	}
}
