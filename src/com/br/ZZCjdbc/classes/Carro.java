package com.br.ZZCjdbc.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.br.ZZCjdbc.conn.ConexaoFactory;

public class Carro {

	private int id;
	private String nome;
	private String placa;
	private Comprador comprador;
	
	public Carro(int id, String nome, String placa, Comprador comprador) {
		this.id = id;
		this.nome = nome;
		this.placa = placa;
		this.comprador = comprador;
	}
	/*
	 * String sql = "DELETE FROM `agencia`.`carro` SET 'placa' =?, 'nome'=? WHERE 'id'=?";
		try (Connection conn = ConexaoFactory.getConexao(); 
			PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setString(1, carro.getPlaca());
			ps.setString(2, carro.getNome());
			ps.setInt(3, carro.getId());
			ps.executeUpdate();
			System.out.println("Registro excluído com sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
	public Carro() {

	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Comprador getComprador() {
		return comprador;
	}
	public void setComprador(Comprador comprador) {
		this.comprador = comprador;
	}
	
	
}
