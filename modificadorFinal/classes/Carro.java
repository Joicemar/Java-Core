package com.br.modificadorFinal.classes;

public class Carro {
	public static final double VELOCIDADE_FINAL = 250;
	private String nome;
	private String marca;
	private final Comprador COMPRADOR = new Comprador();

	@Override
	public String toString() {
		return "carro" + nome + " marca "+ marca;
	}
	public String getNome() {
		return nome;
	}

	public Comprador getComprador() {
		return COMPRADOR;
	}

	public static double getVelocidadeFinal() {
		return VELOCIDADE_FINAL;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	

}
