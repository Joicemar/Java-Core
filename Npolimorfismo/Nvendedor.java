package com.br.Npolimorfismo;


public class Nvendedor extends Funcionario {
    private double totalVendas;

    public Nvendedor(String nome, double salario, double totalVendas) {
        super(nome, salario);
        this.totalVendas = totalVendas;
    }

    @Override
    public void CalcularPagamento() {
        this.salario = this.salario + (totalVendas * 0.5);
    }

    public double getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(double totalVendas) {
        this.totalVendas = totalVendas;
    }
}
