package com.br.basicoDoLivro;
// Livro Desbravando Java e OO. até pg 29 para trás.
//import ClasseLivros;

public class Livro {

	public double preco;
	public String nome;
	public String descricao;
	public String isbn;
	
	public static void main(String[] args){
		
		Livro livros = new Livro();
		
		livros.nome = "Java 8 pratico";
		livros.preco = 50.90;
		livros.descricao = "Novos recursos da linguagem";
		livros.isbn = "90.454.233.432.20";
		
		System.out.println(livros.nome);
		System.out.println(livros.preco);
		System.out.println(livros.descricao);
		System.out.println(livros.isbn);
	}

}
