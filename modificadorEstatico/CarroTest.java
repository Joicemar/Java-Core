package com.br.modificadorEstatico;

public class CarroTest {
	public static void main(String[] args) {
		Carro c1 = new Carro("BMW", 380);
		Carro c2 = new Carro("AUDI", 275);
		Carro c3 = new Carro("Mercedes", 290);
		
		c1.imprime();
		c2.imprime();
		c3.imprime();
		
		System.out.println("#####################");
		/*
		 * 
		 */
		Carro.setVelocidadeLimite(220);
		
		c1.imprime();
		c2.imprime();
		c3.imprime();
	}

}
