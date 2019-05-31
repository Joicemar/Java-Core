package com.br.introducaoClasseTeste;

import com.br.introducaoClassesMetodos.Calculadora;

public class CalculadoraTeste {
	
	public static void main(String[] args){
		/*
		 * Com static n�o precisado criar um novo objeto de classe. Mesmo que o m�todo receba um par�metro o static pressup�e
		 * que esses par�metros j� existam.
		 */
		Calculadora.calculaDoisNumeros();
		Calculadora.subtraiDoisNumeros();
		Calculadora.multiplicaDoisNumeros(5, 5);
		System.out.println("Divis�o de dois n�meros: ");
		
		// Chamamos o m�todo e passamos dois n�meros como par�metro
		System.out.println(Calculadora.divideDoisNumeros(20, 4));
		
		// Aqui estamos atrubuindo valor a variavel por meio do m�todo..
		double result = Calculadora.divideDoisNumeros(20, 2);
		System.out.println(result);
		System.out.println("Continuando a exec...");
		
		System.out.println("Imprimindo dois n�meros divididos...");
		Calculadora.imprimeDoisNumerosDivididos(20, 5);
		
		int[] numeros = {1,2,3,4,5};
		Calculadora.somaArray(numeros);
		//Nesse jeito VarArgs podemos passar a quantidade indefinida diretamente e sem declarar varialvel.
		Calculadora.somaVarArgs(1,2,3,4,5,6);
	}
}
