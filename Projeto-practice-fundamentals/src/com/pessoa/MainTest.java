package com.pessoa;

public class MainTest {

	public static void main(String[] args) {
		
		Pessoa magoFogo = new Mago("Jose", 32, Estado.VIP);
		Pessoa guerreiro = new Guerreiro("Luiz", 32, Estado.VIP);
		
		Registrar registrar = new Registrar();
		
		registrar.listaPessoas.add( magoFogo);
		registrar.listaPessoas.add( guerreiro);
		
		registrar.save(new Mago("Bruxo", 23, Estado.NO_VIP));
		
		registrar.load();
		
	}
}
