package com.br.ZZBClassesInternas;

class Externa{
	
	public static class Interna{
		public void imprimir() {
			System.out.println("Classe Interna");
		}
	}
}

public class ClassesInternasEstaticasTest {
	public static void main(String[] args) {
		
		Externa.Interna teste = new Externa.Interna();
		teste.imprimir();
		
		Interna2 interna2 = new Interna2();
		interna2.imprimir();
	}
	
	static class Interna2{
		public void imprimir() {
			System.out.println("Interna 2");
		}
	}
}
