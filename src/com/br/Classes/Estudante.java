package com.br.Classes;

public class Estudante {
	private String nome;
	private int idade;
	private double[] notas;
	private boolean aprovado;
	
	public void printDados() {
		System.out.println("Dados do aluno:");
		System.out.println("Nome: "+this.nome);
		System.out.println("Idade: "+this.idade+" anos");
		
		if(this.notas != null) {
			for(double nota: this.notas) {
				System.out.println(nota +" ");
			}
		}
	}
	public void tirarMedia() {
		if(this.notas == null) {
			System.out.println("Esse aluno não possui notas");
			return;
		}
		System.out.println("Tirar Média: ");
		double media = 0;
		for(double i: this.notas) {
			media += i;
		}
		media = media/this.notas.length;
		
		if(media > 6) {
			this.aprovado = true;
			System.out.println("\nMedia é: "+ media+" situação: Aprovado.");

		} else {
			this.aprovado = false;
			System.out.println("\nMedia é: "+ media+" situação: Reprovado.");
		}
		

	}
	// getters and setters
	
	public void setNome(String nome) { this.nome = nome; }
	
	public void setIdade(int idade) { this.idade = idade; }
	
	public void setNotas(double[] notas) { this.notas = notas; }
	
	
	public String getNome() { return this.nome; }
	
	public int getIdade() {	return this.idade; }
	
	public double[] getNotas() {return this.notas; }
	
	public boolean isAprovado() {
		return this.aprovado;
	}

}











