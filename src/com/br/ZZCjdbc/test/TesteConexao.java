package com.br.ZZCjdbc.test;

import java.sql.SQLException;
import java.util.List;

import com.br.ZZCjdbc.classes.Comprador;
import com.br.ZZCjdbc.db.CompradorDBOL;

public class TesteConexao {
	public static void main(String[] args) {
//		Connection conn = ConexaoFactory.getConexao();
//		try {
//			conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		// atualizar();
//		List<Comprador> listaComprador = selecionarTudo();
//		List<Comprador> listaComprador2 = buscarNome("Joao");
//		System.out.println(listaComprador);
//		CompradorDB.checkDriverStatus();
//		CompradorDB.testTypeScroll();
//		CompradorDB.updatesNomesToLowerCase();
//		System.out.println(CompradorDB.searchByNamePreparedStatement("ao"));
//		CompradorDB.updatePreparedStatement(new Comprador( 1, "123.123.123.12", "Aldebarom") );
//		System.out.println(CompradorDB.searchByNameCallableStatement("ao"));
//		System.out.println(CompradorDB.searchByNameRowSet("ao"));
//		CompradorDB.updateRowSet( new Comprador(1,"123413545","Joicemar") );
//		CompradorDB.updateRowSetCached(  new Comprador(1,"34234325532","JJJJ")  );
		try {
			CompradorDBOL.saveTransaction();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void inserir() {
		CompradorDBOL compradorDB = new CompradorDBOL();
		Comprador novoC = new Comprador("02498271502", "Paloma");
		compradorDB.save(novoC);
	}

	public static void deletar() {
		Comprador comprador = new Comprador();
		comprador.setId(2);
		CompradorDBOL.delete(comprador);
	}

	public static void atualizar() {
		Comprador comprador = new Comprador(1, "MARIA", "1234123");
		comprador.setId(2);
		CompradorDBOL.updat(comprador);

	}

	public static List<Comprador> selecionarTudo() {
		return CompradorDBOL.selectAll();
	}

	public static List<Comprador> buscarNome(String nome) {
		return CompradorDBOL.searchByName(nome);
	}
}
