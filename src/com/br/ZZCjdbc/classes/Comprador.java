package com.br.ZZCjdbc.classes;



public class Comprador {
	
	Integer id;
	String nome;
	String cpf;
	

	public Comprador(Integer id,String cpf, String nome) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public Comprador(String cpf, String nome) {
		this.nome = nome;
		this.cpf = cpf;
	}
	public Comprador() {
	}
	
	
	@Override
	public String toString() {
		return "Comprador [id=" + id + ", cpf=" + nome + ", nome=" + cpf + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comprador other = (Comprador) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
}
