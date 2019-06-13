package com.br.ZZCjdbc.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.br.ZZCjdbc.classes.Carro;
import com.br.ZZCjdbc.classes.Comprador;
import com.br.ZZCjdbc.conn.ConexaoFactory;

public class CompradorDAO {

	public static void save(Comprador comprador) {
        String sql = "INSERT INTO `agencia`.`comprador` (`cpf`, `nome`) VALUES ( ?, ?)";

        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, comprador.getCpf());
            ps.setString(2, comprador.getNome());
            ps.executeUpdate();
            System.out.println("Registro inserido com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public static void save(Carro carro) {
		String sql = "INSERT INTO `agencia`.`comprador` (`cpf`, `nome`) VALUES ( ?, ?)";
		
		try (Connection conn = ConexaoFactory.getConexao();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, carro.getPlaca());
			ps.setString(2, carro.getNome());
			ps.executeUpdate();
			System.out.println("Registro inserido com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void delete(Comprador comprador) {
		if (comprador == null || comprador.getId() == null) {
			System.out.println("Não foi possível excluir o registro.");
			return;
		}
		// DELETE FROM `agencia`.`comprador` WHERE (`id` = '2');
		String sql = "DELETE FROM `agencia`.`comprador` WHERE `id` = ?;";
		try (Connection conn = ConexaoFactory.getConexao(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, comprador.getId());
			ps.executeUpdate();
			System.out.println("Registro excluído com sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void update(Comprador comprador) {
		if (comprador == null || comprador.getId() == null) {
			System.out.println("Não vou possível excluir o registro.");
			return;
		}
		// DELETE FROM `agencia`.`comprador` WHERE (`id` = '2');
		String sql = "UPDATE `agencia`.`comprador` SET `cpf` = ?, `nome` = ? WHERE `id` = ?";
		try (Connection con = ConexaoFactory.getConexao(); PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, comprador.getCpf());
			ps.setString(2, comprador.getNome());
			ps.setInt(3, comprador.getId());
			ps.executeUpdate();
			System.out.println("Registro atualizado com sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Comprador> selectAll() {
		String sql = "SELECT id, nome, cpf FROM agencia.comprador";

		List<Comprador> compradorList = new ArrayList<>();
		try (Connection con = ConexaoFactory.getConexao();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {

			while (rs.next()) {
				compradorList.add(new Comprador(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf")));

			}
			return compradorList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<Comprador> searchByName(String nome) {
		String sql = "SELECT id, nome, cpf FROM agencia.comprador where nome like ?";
		List<Comprador> compradorList = new ArrayList<>();
		try (Connection con = ConexaoFactory.getConexao(); PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, "%" + nome + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				compradorList.add(new Comprador(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf")));

			}
			ConexaoFactory.close(con, ps, rs);
			return compradorList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static Comprador searchById(Integer id) {
		String sql = "SELECT id, nome, cpf FROM agencia.comprador where id=?";
		Comprador comprador = null;
		try (Connection con = ConexaoFactory.getConexao(); PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				comprador = new Comprador(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"));

			}
			ConexaoFactory.close(con, ps, rs);
			return comprador;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
