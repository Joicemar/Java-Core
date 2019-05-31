package com.br.introducaoClassesMetodos;

public class Calculadora {
	//public void quer dizer que essa classe N retorna nenhum valor
	// public void, são métodos
	public static void calculaDoisNumeros(){
		System.out.println(5+5);
	}
	public static void subtraiDoisNumeros(){
		System.out.println("10 - 5 = "+(10-5));
	}
	public static void multiplicaDoisNumeros(int num, int num2){
		System.out.println(num+" x "+num2+" = "+(num*num2));
	}
	public static double divideDoisNumeros(double num1, double num2){
		if (num2 != 0){
			return (int) num1 / num2;
		}
		return 0;
	}
	public static void imprimeDoisNumerosDivididos(double num1, double num2){
		if(num2 != 0){
			System.out.println(num1 / num2);
			// Esse return serve como um break no método
			return;
		}
		System.out.println("Não é possível dividir por Zero.");
	}
	public static void alteraDoisNumeros(int num1, int num2){
		num1 = 20; num2 = 40;
		System.out.println("Dentro do alteraDoisNumeros");
		System.out.println("num1: "+num1+"\nnum2: "+num2);
	}
	public static void somaArray(int[] numeros){
		int soma = 0;
		for (int num : numeros){
			soma += num;
		}
		System.out.println(soma);
	}
	public static void somaVarArgs(int... numeros){
		int soma = 0;
		for (int num : numeros){
			soma += num;
		}
		System.out.println(soma);
	}
	
	
}
