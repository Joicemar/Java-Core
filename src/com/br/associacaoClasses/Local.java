package com.br.associacaoClasses;

public class Local {
	private String bairro;
	private String rua;
	
	
	
	public Local() {
	}
	
	public Local (String bairro, String rua) {
		this.bairro = bairro;
		this.rua = rua;
	}
	
	public void print() {
		System.out.println("----------------Relatório do Local----------------");
		System.out.println("Rua: " + this.rua);
		System.out.println("Bairro: "+this.bairro);
		
	}

	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}

}
