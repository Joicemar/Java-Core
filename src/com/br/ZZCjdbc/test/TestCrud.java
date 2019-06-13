package com.br.ZZCjdbc.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.br.ZZCjdbc.classes.Comprador;
import com.br.ZZCjdbc.db.CompradorDAO;

public class TestCrud {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int op;
		while (true) {
			menu();
			op = Integer.parseInt(teclado.nextLine());
			System.out.println(op);
			if (op == 0) {
				System.out.println("saindo");
				break;
			}
			if(op == 1) {
				menuComprador();
				op = Integer.parseInt(teclado.nextLine());
				CompradorCRUD.executar(op);
			}
			if(op == 2) {
				menuCarro();
				op = Integer.parseInt(teclado.nextLine());
				CarroCRUD.executar(op);
			}
		}

	}
	
	public static void menu() {
		System.out.println("Escolha uma das opções");
		System.out.println("1. Comprador");
		System.out.println("2. Carro");
		System.out.println("3, Sair");
		
	}

	public static void menuComprador() {
		System.out.println("Escolha uma das opções");
		System.out.println("1 - Inserir Comprador");
		System.out.println("2 - Atualizar comprador");
		System.out.println("3 - Listar todos os compradores");
		System.out.println("4 - Buscar comprador por nome");
		System.out.println("5 - Deletar");
		System.out.println("6 - Sair\n");
	}

	public static void menuCarro() {
		System.out.println("carro");
		System.out.println("Carros Escolha uma das opções");
		System.out.println("1 - Inserir Carro");
		System.out.println("2 - Atualizar Carror");
		System.out.println("3 - Listar todos os Carros");
		System.out.println("4 - Buscar Carro por nome");
		System.out.println("5 - Deletar");
		System.out.println("6 - Sair\n");
	}

}
