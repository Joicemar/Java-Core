package com.br.introducaoClassesMetodos;

import com.br.Classes.Professor;

public class ProfessorTeste {
	public static void main(String[] args) {
		Professor prof = new Professor();
		prof.cpf = 234235326;
		prof.matricula = "345";
		prof.nome = "Jose";
		prof.rg = 23423523;
		prof.imprime();
		
	}
}
