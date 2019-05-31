package com.br.introducaoClasseTeste;

import com.br.Classes.Estudante;

public class EstudanteTest {
	public static void main(String args[]) {
		Estudante estudante = new Estudante();
		
		estudante.setNome("Joicemar");
		estudante.setIdade(-1);
		estudante.setNotas(new double[]{6,7,8,9});

		estudante.printDados();
		estudante.tirarMedia();
		estudante.isAprovado();
	}
}
