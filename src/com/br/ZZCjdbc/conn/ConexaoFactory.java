package com.br.ZZCjdbc.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class ConexaoFactory {

	public static Connection getConexao() {

		String url = "jdbc:mysql://localhost:3306/agencia?useSSL=false";
		String user = "root";
		String password = "root";

		try {
			// Class.forName("com.mysql.jdbc.Driver");
			// Connection connection = DriverManager.getConnection(url, user, password);
			// System.out.println(connection);
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static JdbcRowSet getRowSetConnection() {

		String url = "jdbc:mysql://localhost:3306/agencia?useSSL=false";
		String user = "root";
		String password = "root";

		try {
			JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();
			jdbcRowSet.setUrl(url);
			jdbcRowSet.setUsername(user);
			jdbcRowSet.setPassword(password);

			return jdbcRowSet;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static CachedRowSet getRowSetConnectionCached() {
		
		String url = "jdbc:mysql://localhost:3306/agencia?useSSL=false&relaxAutoCommit=true";
		String user = "root";
		String password = "root";
		
		try {
			CachedRowSet cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
			cachedRowSet.setUrl(url);
			cachedRowSet.setUsername(user);
			cachedRowSet.setPassword(password);
			
			return cachedRowSet;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void close(Connection c) {
		try {
			if (c != null)
				c.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(RowSet jrs) {
		try {
			if (jrs != null)
				jrs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection c, Statement t) {
		close(c);
		try {
			t.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void close(Connection con, Statement stmt, ResultSet rs) {
		close(con);
		try {
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
//?useSSL=false
