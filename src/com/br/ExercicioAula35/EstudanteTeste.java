package com.br.ExercicioAula35;

public class EstudanteTeste {
	public static void main(String[] args) {
		
		Estudante e = new Estudante();
		
		e.nome = "Joicemar";
		e.idade = 28;
		e.notas = new double[] {6,7,8};
		
		//System.out.println(e.nome);
		//System.out.println(e.idade);
		//System.out.println(e.notas);
		e.tirarMedia();
		e.printDados();
	}
}
