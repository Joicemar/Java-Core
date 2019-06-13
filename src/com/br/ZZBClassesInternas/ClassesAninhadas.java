package com.br.ZZBClassesInternas;

public class ClassesAninhadas {
	private String nome = "Joicemar";
	
	class Interna {
		public void verClasseExterna() {
			System.out.println(nome);
			System.out.println(this);
			System.out.println(ClassesAninhadas.this);
		}
	}

	public static void main(String[] args) {
		
		ClassesAninhadas.Interna n1 = new ClassesAninhadas(). new Interna();
		ClassesAninhadas externa = new ClassesAninhadas();
		ClassesAninhadas.Interna n2 = externa. new Interna();
		
		n1.verClasseExterna();
	}
}
