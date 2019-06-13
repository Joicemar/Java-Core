package com.br.Npolimorfismo.teste;

import com.br.Npolimorfismo.Gerente;
import com.br.Npolimorfismo.Nvendedor;
import com.br.Npolimorfismo.RelatorioPagamento;

public class PolimorfismoTest {
    public static void main(String[] args) {
        Gerente g = new Gerente("Marcos", 5000, 2000);
        Nvendedor v = new Nvendedor("pedro", 2000, 2000);
        RelatorioPagamento relatorio = new RelatorioPagamento();
//        relatorio.relatorioPagamentoGerente(g);
//        System.out.println("------------------------------");
//        relatorio.relatorioPagamentoVendedor(v);

        relatorio.relatorioPagamentoGenerico(g);
//        System.out.println("------------------------------");
        relatorio.relatorioPagamentoGenerico(v);

//        Npolimorfismo.Funcionario f = g;
//        System.out.println(f.getSalario());
    }
}
