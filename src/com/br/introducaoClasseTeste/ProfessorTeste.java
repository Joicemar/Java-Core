package com.br.introducaoClasseTeste;

import com.br.Classes.Professor;

public class ProfessorTeste {
	public static void main(String[] args){
		
		Professor prof = new Professor();
	
		prof.nome = "Andre";
		prof.matricula = "1134";
		prof.rg = 123539203;
		prof.cpf = 1234596054;
		
		Professor prof2 = new Professor();
		prof2.nome = "Pedro";
		prof2.matricula = "756";
		prof2.rg = 23455553;
		prof2.cpf = 94234450;
		
		prof.imprime(); // Aqui imprimimos tudo atravaz do metodo imprime
		prof2.imprime(); // E o metodo faz referencia a o local de memoria desse(s) objetos.
		// Se fosse prof2.imprime o resultado seria o mesmo ...
	}
}
