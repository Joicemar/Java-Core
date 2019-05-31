package com.br.heranca;

public class Funcionario extends Pessoa{
	private double salario;
		
	
	public Funcionario(String nome){super(nome);}
	
	public void imprime() {
		super.imprime();
		System.out.println("Salario: "+this.salario);
		imprimePagamento();
	}

	public void imprimePagamento() {
		System.out.println("Eu "+this.nome+" recebi o pagamento.");
	}
	public double getSalario() {
		return salario;
	}

	public void setSalario(double i) { this.salario = i; }

	
}
