package com.pessoa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Registrar implements Data {

	public static List<Pessoa> listaPessoas;
	File file;

	public Registrar() {
		listaPessoas = new ArrayList<Pessoa>();
		file = new File("file.txt");
	}

	void listar() {
		for (Pessoa ps : listaPessoas) {
			System.out.println(ps.toString());
		}
	}

	@Override
	public void save(Pessoa pessoa) {

		try {
			FileWriter fileWriter = new FileWriter(file, true);
			fileWriter.write(pessoa.toString()+"\n");
			fileWriter.flush();

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Erro na criação, leitura ou escrita do arquivo.");
		}

	}

	@Override
	public void load() {
		try {
			FileReader reader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(reader);
			
			String linha;
			while( (linha = bufferedReader.readLine()) != null ) {
				System.out.println(linha);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	
}







