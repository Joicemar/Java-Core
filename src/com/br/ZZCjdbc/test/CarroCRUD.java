package com.br.ZZCjdbc.test;

import java.util.List;
import java.util.Scanner;

import com.br.ZZCjdbc.classes.Carro;
import com.br.ZZCjdbc.classes.Comprador;
import com.br.ZZCjdbc.db.CarroDAO;
import com.br.ZZCjdbc.db.CompradorDAO;

public class CarroCRUD {

	public static Scanner teclado = new Scanner(System.in);

	public static void executar(int op) {

		switch (op) {
		case 1:
			inserir();
			break;
		case 2:
			atualizar();
		case 3:
			listar();
			break;
		case 4:
			System.out.println("Buscar por nome: ");
			Buscar_PorNome(teclado.nextLine());
		case 5:
			deletar(); 
			break;
		}
	}
	
	public static void inserir() {
		Carro c = new Carro();
		System.out.println("Nome:");
		c.setNome(teclado.nextLine());
		System.out.println("Placa:");
		c.setPlaca(teclado.nextLine());
		System.out.println("Selecionar um dos compradores abaixo");
		List<Comprador> compradorList = CompradorCRUD.listar();
		c.setComprador(compradorList.get(Integer.parseInt(teclado.nextLine())));
		CarroDAO.save(c);
	}

	public static void atualizar() {
		System.out.println("Selecione um dos carros abaixo");
		List<Carro> carroList = listar();
		Carro c = carroList.get(Integer.parseInt(teclado.nextLine()));
		System.out.println("Novo nome ou enter para manter o mesmo");
		String nome = teclado.nextLine();
		System.out.println("Novo cpf ou enter para manter o mesmo");
		String placa = teclado.nextLine();
		if (!nome.isEmpty()) {
			c.setNome(nome);
		}
		if (!placa.isEmpty()) {
			c.setPlaca(placa);
		}
		CarroDAO.update(c);
	}

	public static List<Carro> listar() {
		List<Carro> carroList = CarroDAO.selectAll();
		for (int i = 0; i < carroList.size(); i++) {
			Carro c = carroList.get(i);
			System.out.println("[ " + i + " ]" + "Nome:" + c.getPlaca() + " "+" Cpf: " + c.getNome() + " "+c.getComprador().getNome());
		}
		return carroList;
	}

	public static void Buscar_PorNome(String nome) {
		List<Carro> carroList = CarroDAO.searchByName(nome);
		for (int i = 0; i < carroList.size(); i++) {
			Carro c = carroList.get(i);
			System.out.println("[ " + i + " ]" + "Nome:" + c.getPlaca() + " "+" Cpf: " + c.getNome() + " "+c.getComprador().getNome());
		}
	}

	public static void deletar() {
		System.out.println("Selecione um dos carros abaixo:");
		List<Carro> carroList = listar();
		int index = Integer.parseInt(teclado.nextLine());
		System.out.println("Tem certeza? S/N");
		String op = teclado.nextLine();
		if(op.startsWith("s")) {
			CarroDAO.delete(carroList.get(index));
		}
	}
	
	
}
