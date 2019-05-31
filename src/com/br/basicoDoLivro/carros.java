package com.br.basicoDoLivro;

import com.br.introducaoClasseTeste.carroteste;

public class carros {
	
	public static void main(String[] args){
		carroteste Carros = new carroteste();
		Carros.carro = "skiline";
		Carros.vMax = 120.0f;
		
		System.out.println(Carros.carro);
		System.out.println(Carros.vMax);
	}

}
