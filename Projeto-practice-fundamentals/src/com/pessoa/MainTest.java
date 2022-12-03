package com.pessoa;

public class MainTest {

	public static void main(String[] args) {
		
		Mago magoFogo = new Mago("Jose", 32, Estado.VIP);
		Guerreiro guerreiro = new Guerreiro("Luiz", 32, Estado.VIP);
		
		Registrar registrar = new Registrar();
		
		registrar.listaPessoas.add( magoFogo);
		registrar.listaPessoas.add( guerreiro);
		
		registrar.listar();
		
	}
}
