package com.br.heranca;

public class TestHeranca {
	public static void main(String[] args) {
		
		Endereco end = new Endereco();
		end.setBairro("Figueirinha");
		end.setRua("Arara Azul");
		
		Pessoa p = new Pessoa("joao");
		p.setNome("Gina");
		p.setCpf("234566");
		p.setEndereco(end);
		p.imprime();

		
		System.out.println("==========================================");
		Funcionario fun = new Funcionario("Jose");
		fun.setSalario(1234);
		fun.setNome("Joao");
		fun.setCpf("123.435.345.23");
		fun.setEndereco(end);
		fun.imprime();
		
	}
}
