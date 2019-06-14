package com.br.sobrecargaMetodos.test;

import com.br.sobrecargaDeMetodos.Funcionario;

public class FuncionarioTest {
	public static void main(String[] args) {
		/*Passando argumentos através do construtor
		 * */
		Funcionario funcionario = new Funcionario("Jubileu","012.234.64.422" , 4500, "23453256");
		Funcionario funcionario2 = new Funcionario();
		
		//funcionario.init("Jubileu","012.234.64.422" , 4500, "23453256");
		funcionario.imprime();
		funcionario2.imprime();

	}
}
