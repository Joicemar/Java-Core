package com.br.introducaoClasseTeste;

import com.br.basicoDoLivro.Teste;

public class EstudanteTeste {
	public static void main(String[] args){
		
		Teste joao = new Teste();
		
		joao.matricula = "1023";
		joao.nome = "João";
		joao.idade = 12;
	
		System.out.println(joao.matricula);
		System.out.println(joao.nome);
		System.out.println(joao.idade);
	}

}
