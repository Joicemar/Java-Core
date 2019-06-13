package com.br.ZZBClassesInternas;

public class ClassesLocaisTest {
	private String nome = "Joicemar";
	
	public void fazAlgumaCoisa() {
		String sobreNome = "SM";
		class Interna{
			public void imprimeNomeExterno() {
				System.out.println(nome);
			}
		}
		Interna n = new Interna();
		n.imprimeNomeExterno();
	}
	
	
	public static void main(String[] args) {
		ClassesLocaisTest externa = new ClassesLocaisTest();
		externa.fazAlgumaCoisa();
	}

}
