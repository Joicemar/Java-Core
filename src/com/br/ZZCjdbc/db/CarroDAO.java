package com.br.ZZCjdbc.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.br.ZZCjdbc.classes.Carro;
import com.br.ZZCjdbc.classes.Comprador;
import com.br.ZZCjdbc.conn.ConexaoFactory;

public class CarroDAO {

	public static void save(Carro carro) {
		String sql = "INSERT INTO `agencia`.`carro` (`placa`, `nome`, comprador_id) VALUES ( ?, ?, ?)";

		try (Connection conn = ConexaoFactory.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, carro.getNome());
			ps.setString(2, carro.getPlaca());
			ps.setInt(3, carro.getComprador().getId());
			ps.executeUpdate();
			System.out.println("Registro inserido com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void delete(Carro carro) {
		if (carro == null || carro.getId() < 0) {
			System.out.println("Não foi possível excluir o registro.");
			return;
		}
		// DELETE FROM `agencia`.`comprador` WHERE (`id` = '2');
		String sql = "DELETE FROM `agencia`.`carro` WHERE `id` = ?;";
		try (Connection conn = ConexaoFactory.getConexao(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, carro.getId());
			ps.executeUpdate();
			System.out.println("Registro excluído com sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void update(Carro carro) {
		if (carro == null || carro.getId() < 0) {
			System.out.println("Não vou possível excluir o registro.");
			return;
		}
		String sql = "DELETE FROM `agencia`.`carro` SET 'placa' =?, 'nome'=? WHERE 'id'=?";
		try (Connection conn = ConexaoFactory.getConexao(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setString(1, carro.getPlaca());
			ps.setString(2, carro.getNome());
			ps.setInt(3, carro.getId());
			ps.executeUpdate();
			System.out.println("Registro atualizado com sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Carro> selectAll() {
		String sql = "SELECT id, nome, placa, comprador_id FROM agencia.carro";

		List<Carro> carroList = new ArrayList<>();
		try (Connection con = ConexaoFactory.getConexao();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {

			while (rs.next()) {
				Comprador c = CompradorDAO.searchById(rs.getInt("comprador_id"));
				carroList.add(new Carro(rs.getInt("id"), rs.getString("nome"), rs.getString("placa"), c));

			}
			return carroList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<Carro> searchByName(String nome) {
		String sql = "SELECT id, nome, placa, comprador_id FROM agencia.carro where nome like ?";
		List<Carro> carroList = new ArrayList<>();
		try (Connection con = ConexaoFactory.getConexao(); PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, "%" + nome + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Comprador c = CompradorDAO.searchById(rs.getInt("comprador_id"));
				carroList.add(new Carro(rs.getInt("id"), rs.getString("nome"), rs.getString("placa"), c));

			}
			ConexaoFactory.close(con, ps, rs);
			return carroList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
