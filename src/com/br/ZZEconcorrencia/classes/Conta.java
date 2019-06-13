package com.br.ZZEconcorrencia.classes;

public class Conta {
	
	double saldo = 10;

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void saque(double valor) {
		saldo -= valor;
	}
	

}
