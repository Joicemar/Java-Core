package com.br.ZZCjdbc.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;

import com.br.ZZCjdbc.classes.Comprador;
import com.br.ZZCjdbc.classes.MyRowSetListener;
import com.br.ZZCjdbc.conn.ConexaoFactory;
import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.PreparedStatement;
import com.sun.org.apache.regexp.internal.recompile;

public class CompradorDBOL {

	public static void save(Comprador c) {
		String sql = "INSERT INTO `agencia`.`comprador` (`cpf`, `nome`) VALUES ('" + c.getNome() + "', '" + c.getCpf()
				+ "' )";
		Connection con = ConexaoFactory.getConexao();

		try {
			Statement ps = con.createStatement();
			ps.executeUpdate(sql);
			ConexaoFactory.close(con, ps);
			System.out.println("Registro inserido com sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void saveTransaction() throws SQLException {
		String sql = "INSERT INTO `agencia`.`comprador` (`cpf`, `nome`) VALUES ('TESTE1', 'TESTECPF1test' )";
		String sql2 = "INSERT INTO `agencia`.`comprador` (`cpf`, `nome`) VALUES ('TESTE2', 'TESTECPF2' )";
		String sql3 = "INSERT INTO `agencia`.`comprador` (`cpf`, `nome`) VALUES ('TESTE3', 'TESTECPF3' )";
		Connection conn = ConexaoFactory.getConexao();
		Savepoint savepoint = null;
		try {
			conn.setAutoCommit(false);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			savepoint = conn.setSavepoint("One");
			stmt.executeUpdate(sql2);
			if (true)
				throw new SQLException();
			stmt.executeUpdate(sql3);
			conn.commit();
			ConexaoFactory.close(conn, stmt);
			System.out.println("Registro inserido com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback(savepoint);
			conn.commit();
		}
	}


	public static void delete(Comprador comprador) {
		if (comprador == null || comprador.getId() == null) {
			System.out.println("Não foi possível excluir o registro.");
			return;
		}
		// DELETE FROM `agencia`.`comprador` WHERE (`id` = '2');
		String sql = "DELETE FROM `agencia`.`comprador` WHERE `id` = " + comprador.getId() + ";";
		Connection con = ConexaoFactory.getConexao();

		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);
			ConexaoFactory.close(con, stmt);
			System.out.println("Registro excluído com sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updat(Comprador comprador) {
		if (comprador == null || comprador.getId() == null) {
			System.out.println("Não vou possível excluir o registro.");
			return;
		}
		// DELETE FROM `agencia`.`comprador` WHERE (`id` = '2');
		String sql = "UPDATE `agencia`.`comprador` SET `cpf` = '" + comprador.getCpf() + "', `nome` = '"
				+ comprador.getNome() + "' WHERE (`id` = '" + comprador.getId() + "');";

		Connection con = ConexaoFactory.getConexao();

		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);
			ConexaoFactory.close(con, stmt);
			System.out.println("Registro atualizado com sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updatePreparedStatement(Comprador comprador) {
		/*PrepateStatement prepara o objeto para executar ações, e no comando
		 * executeUpdate() ele as executa no banco de dados*/
		if (comprador == null || comprador.getId() == null) {
			System.out.println("Não vou possível excluir o registro.");
			return;
		}
		// DELETE FROM `agencia`.`comprador` WHERE (`id` = '2');
		String sql = "UPDATE `agencia`.`comprador` SET `cpf` = ?, `nome` = ? WHERE `id` = ?";

		Connection conn = ConexaoFactory.getConexao();

		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, comprador.getCpf());
			ps.setString(2, comprador.getNome());
			ps.setInt(3, comprador.getId());
			ps.executeUpdate();

			ConexaoFactory.close(conn, ps);
			System.out.println("Registro atualizado com sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updateRowSet(Comprador comprador) {
		/*
		 * Não podemos atualizar com o RowSet, somente pegar e atrabalhar com os dados
		 */
		if (comprador == null || comprador.getId() == null) {
			System.out.println("Não vou possível atualizar o registro.");
			return;
		}
//		String sql = "UPDATE `agencia`.`comprador` SET `cpf` = ?, `nome` = ? WHERE `id` = ?";
		String sql = "SELECT * FROM Comprador where id = ?";
		JdbcRowSet jrs = ConexaoFactory.getRowSetConnection();
		jrs.addRowSetListener(new MyRowSetListener());
		try {
			jrs.setCommand(sql);
//			jrs.setString(1, comprador.getCpf());
//			jrs.setString(2, comprador.getNome());
			jrs.setInt(1, comprador.getId());
			jrs.execute();
			jrs.next();
			jrs.updateString("nome", "Joicemar");
			jrs.updateRow();
			ConexaoFactory.close(jrs);
			System.out.println("Registro atualizado com sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updateRowSetCached(Comprador comprador) {
		/*
		 * Não podemos atualizar com o RowSet, somente pegar e atrabalhar com os dados
		 */
		if (comprador == null || comprador.getId() == null) {
			System.out.println("Não vou possível atualizar o registro.");
			return;
		}
		String sql = "SELECT * FROM Comprador where id = ?";
		CachedRowSet crs = ConexaoFactory.getRowSetConnectionCached();
		try {
			crs.setCommand(sql);
			crs.setInt(1, comprador.getId());
			crs.execute();
			crs.next();
			crs.updateString("nome", "JJJ");
			crs.updateRow();
			crs.acceptChanges();
			System.out.println("Registro atualizado com sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Comprador> selectAll() {
		String sql = "SELECT id, nome, cpf FROM agencia.comprador";
		Connection con = ConexaoFactory.getConexao();
		List<Comprador> compradorList = new ArrayList<>();

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				compradorList.add(new Comprador(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf")));

			}
			ConexaoFactory.close(con, stmt, rs);
			return compradorList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<Comprador> searchByName(String nome) {
		String sql = "SELECT id, nome, cpf FROM agencia.comprador where " + nome + " like '%ria'";
		Connection con = ConexaoFactory.getConexao();
		List<Comprador> compradorList = new ArrayList<>();

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				compradorList.add(new Comprador(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf")));

			}
			ConexaoFactory.close(con, stmt, rs);
			return compradorList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<Comprador> searchByNameRowSet(String nome) {
		/* Conectando com RowSet */
		String sql = "SELECT id, nome, cpf FROM agencia.comprador where nome like ?"; // Com % pega somente o que está
																						// pedindo
		JdbcRowSet jrs = ConexaoFactory.getRowSetConnection();
		List<Comprador> compradorList = new ArrayList<>();
		jrs.addRowSetListener(new MyRowSetListener());
		try {
			jrs.setCommand(sql);
			jrs.setString(1, "%" + nome + "%");
			jrs.execute();

			while (jrs.next()) {
				compradorList.add(new Comprador(jrs.getInt("id"), jrs.getString("nome"), jrs.getString("cpf")));

			}
			ConexaoFactory.close(jrs);
			return compradorList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void selectMetaData() {
		String sql = "SELECT * FROM agencia.comprador";
		Connection con = ConexaoFactory.getConexao();

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			rs.next();

			int qtdColuns = rsmd.getColumnCount(); // pega a quantidade de colunar do DB
			System.out.println("qtd colunas: " + qtdColuns);

			for (int i = 1; i < qtdColuns; i++) {
				System.out.println("tabela: " + rsmd.getTableName(i));
				System.out.println("Nome coluna: " + rsmd.getColumnName(i));
				System.out.println("Tamanho coluna: " + rsmd.getColumnDisplaySize(i));
			}

			ConexaoFactory.close(con, stmt, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void checkDriverStatus() {
		// check drive type that support for the bank data base
		Connection conn = ConexaoFactory.getConexao();
		try {
			DatabaseMetaData dbmd = conn.getMetaData();
			if (dbmd.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {// só pode ir para frente
				System.out.println("Suporta TYPE_FORWARD_ONLY");
				if (dbmd.supportsResultSetConcurrency(ResultSet.CONCUR_READ_ONLY, ResultSet.CONCUR_UPDATABLE))
					;
				System.out.println("E também suporta CONCUR_UPDATABLE");
			}
			if (dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {// pode ir para frente e para trás e
																				// nenhum mudança afeta o db
				System.out.println("Suporta TYPE_SCROLL_INSENSITIVE");
				if (dbmd.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
					System.out.println("Também suporta CONCUR_UPDATABLE");
				}
			}
			if (dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {// pode is para frente e atras e afeta o
																				// db
				System.out.println("Suporta TYPE_SCROLL_SENSITIVE");
				if (dbmd.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
					System.out.println("Também suporta CONCUR_UPDATABLE");
				}
			}
			ConexaoFactory.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void testTypeScroll() {
		String sql = "SELECT id, nome, cpf FROM agencia.comprador";
		Connection con = ConexaoFactory.getConexao();
		List<Comprador> compradorList = new ArrayList<>();

		try {
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.last()) {
				System.out.println(
						"Ultimo nome: " + new Comprador(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf")));
				System.out.println("linha: " + rs.getRow());
				rs.absolute(7);
				System.out.println("linha 7: " + rs.getRow());
				rs.relative(-1);
				System.out.println("Voltamos para linha 6: " + rs.getRow());

				System.out.println(rs.isLast());
				System.out.println(rs.isFirst());
				System.out.println("///////////////");
				while (rs.previous()) {
					System.out.println(new Comprador(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf")));
				}
			}
			System.out.println("Retornou para primeira linha " + rs.first());
			ConexaoFactory.close(con, stmt, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updatesNomesToLowerCase() {
		String sql = "SELECT id, nome, cpf FROM agencia.comprador";
		Connection conn = ConexaoFactory.getConexao();

		try {
			DatabaseMetaData dbmt = conn.getMetaData();

			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(sql);
			/* Verifica se é possível atualizar, inserir e deletar */
			System.out.println(dbmt.updatesAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));
			System.out.println(dbmt.insertsAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));
			System.out.println(dbmt.deletesAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));

			while (rs.next()) {
				/* Ira mudar somente no statement e nao no banco de dados */
				rs.updateString("nome", rs.getString("nome").toLowerCase());
				/*
				 * Ele cancela os updates para não dar resultados errados, O updateString terá
				 * resultados insertos se usado mais de uma vez, segundo a documentação
				 */
				rs.cancelRowUpdates();
				/* Atualiza no bando de dados */
				rs.updateRow();
				/* Se rs for capaz de atualizar */
//				if(rs.rowUpdated()) {
//					System.out.println("linha atualizada");
//				}
			}
//			rs.first();
//			while(rs.next()) {
//				System.out.println(rs.getString("nome"));
//			}
			rs.absolute(2);
			String nome = rs.getString("nome");
			rs.moveToInsertRow();
			rs.updateString("nome", nome.toUpperCase());
			rs.updateString("cpf", "999.999.999.99");
			rs.insertRow();
			rs.moveToCurrentRow();
			System.out.println(rs.getString("nome") + " row" + rs.getRow());
			rs.absolute(7);
			rs.deleteRow();

			ConexaoFactory.close(conn, stmt, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Comprador> searchByNamePreparedStatement(String nome) {
//		String sql = "SELECT id, nome, cpf FROM agencia.comprador where nome like '"+ nome + "'"; //Sem o % ele permite o sql injection
		String sql = "SELECT id, nome, cpf FROM agencia.comprador where nome like ?"; // Com % pega somente o que está
																						// pedindo
		Connection conn = ConexaoFactory.getConexao();
		List<Comprador> compradorList = new ArrayList<>();

		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, "%" + nome + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				compradorList.add(new Comprador(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf")));

			}
			ConexaoFactory.close(conn, ps, rs);
			return compradorList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/* Mostro como chamar as procedues no bando de dados */
	public static List<Comprador> searchByNameCallableStatement(String nome) {
		String sql = "CALL `agencia`.`SP_GetCompradoresPorNome`( ? );";
		Connection conn = ConexaoFactory.getConexao();
		List<Comprador> compradorList = new ArrayList<>();

		try {
			CallableStatement cs = (CallableStatement) conn.prepareCall(sql);
			cs.setString(1, "%" + nome + "%");
			ResultSet rs = cs.executeQuery();

			while (rs.next()) {
				compradorList.add(new Comprador(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf")));

			}
			ConexaoFactory.close(conn, cs, rs);
			return compradorList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
