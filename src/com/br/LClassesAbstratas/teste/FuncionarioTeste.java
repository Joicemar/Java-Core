package com.br.LClassesAbstratas.teste;

import com.br.LClassesAbstratas.Classes.Gerente;
import com.br.LClassesAbstratas.Classes.Vendedor;

public class FuncionarioTeste {
	public static void main(String[] args) {

		Gerente g = new Gerente("Ana", "2845745", 2000);
		Vendedor v = new Vendedor("maria", "023954", 1500, 5000);

		v.calculaSalario();
		g.calculaSalario();
		System.out.println(g);
		System.out.println(v);
	}
}
