package com.br.associacaoClasses;

public class Seminario {
	private String titulo;
	private Aluno[] alunos;
	private Professor professor;
	private Local local;

	public Seminario() {
	}

	public Seminario(String titulo) {
		this.titulo = titulo;
	}

	public void print() {
		System.out.println("----------Relatórios de Seminários-----------");
		System.out.println("Titulo: " + this.titulo);
		if (this.professor != null)
			System.out.println("Professor palestrante: " + this.professor.getNome());
		else
			System.out.println("Nenhum professor cadastrado para esse seminário");

		if (this.local != null)
			System.out.println("Local, rua: " + this.local.getRua() + " Bairro: " + this.local.getBairro());
		else
			System.out.println("Nenhum local cadastrado para esse seminário");
		
		if (this.alunos != null && this.alunos.length != 0) {
			for (Aluno alunos : alunos) {
				System.out.println(alunos.getNome());
			}
			return;
		}
		System.out.println("Nenhum aluno cadastrado");
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setAlunos(Aluno[] alunos) {
		this.alunos = alunos;
	}

	public Aluno[] getAlunos() {
		return alunos;
	}
}
