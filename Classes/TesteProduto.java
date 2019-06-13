package com.br.Minterfaces.Classes;

public class TesteProduto {
    public static void main(String[] args) {
        Produto p = new Produto("notebook", 4, 3000);
        p.calculaImposto();
        p.calculaFrete();
        System.out.println(p);
    }
}
