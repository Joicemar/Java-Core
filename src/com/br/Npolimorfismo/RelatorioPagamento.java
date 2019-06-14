package com.br.Npolimorfismo;

public class RelatorioPagamento {

//    public void relatorioPagamentoGerente(Gerente gerente){
//        System.out.println("Gerando relatório do pagamento para a gerencia");
//        gerente.CalcularPagamento();
//        System.out.println("Gerente nome: "+ gerente.getNome());
//        System.out.println("Gerente salário do mês: "+ gerente.getSalario());
//    }
//    public void relatorioPagamentoVendedor(Nvendedor vendedor) {
//        System.out.println("Gerando relatório do pagamento para vendedor");
//        vendedor.CalcularPagamento();
//        System.out.println("Vendedor nome: " + vendedor.getNome());
//        System.out.println("Vendedor salário do mês: " + vendedor.getSalario());
//    }
    public void relatorioPagamentoGenerico(Funcionario funcionario) {
        System.out.println("Gerando relatorio de pegamento");
        funcionario.CalcularPagamento();
        System.out.println("Nome: "+funcionario.getNome());
        System.out.println("Salario desse mes: "+funcionario.getSalario());
        if(funcionario instanceof Gerente){
            //O objeto funcionario esta fazendo referência para gerente, modo explicito.
            //Como Gerente é filho de Funcionario, o funcionario passa a ser um objeto do tipo gerente
            Gerente g = (Gerente) funcionario;
            System.out.println("Participacao dos Lucros: "+g.getPnl());
        }
        if(funcionario instanceof  Nvendedor){
            //Cast direto, como se tudo fosse umavariavel de referencia e chamamos o metodo direto por ela
            System.out.println("Total vendas: "+((Nvendedor) funcionario).getTotalVendas());
        }

    }
}
