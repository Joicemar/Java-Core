package com.br.ExercicioAula35;

public class Estudante {
	public String nome;
	public int idade;
	public double[] notas;
	
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
			System.out.println("Aprovado");
			System.out.println("Media do aluno é: "+ media);
			return;
		}
		System.out.println("reprovado");
		
		System.out.println("Media do aluno é: "+ media);
	}
	
}
