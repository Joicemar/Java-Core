package com.br.sobrescrita;

public class PessoaTest {
	public static void main(String[] args) {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("maria");
		pessoa.setIdade(12);
		
		System.out.println(pessoa);
		pessoa.getClass();
	}

}
