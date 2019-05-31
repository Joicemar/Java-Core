package com.br.Classes;

// Crie os seguintes atributos para essa classe
	//nome
	//matricula
	//RG
	//CPF
public class Professor {
// Crie uma classe de teste para preencher e imprimir os dados desse professor
	
	public String nome;
	public String matricula;
	public int rg;
	public int cpf;
	// Criamo um m�todos para imprimir(void sgn que m retorna Valor), 
	// metodo que recebe um parametro(var prof)
	public void imprime(){
		System.out.println("==============================");
		System.out.println("Nome: "+this.nome);
		System.out.println("matricula: "+this.matricula);
		System.out.println("RG: "+this.rg);
		System.out.println("CPF: "+this.cpf);
		// O this vai servir de referencia, substituir qualquer objeto pelo nome.
		// this palavra usada para pegar o valor do proprio objeto
	}
}