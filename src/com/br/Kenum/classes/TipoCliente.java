package com.br.Kenum.classes;

public enum TipoCliente {
    PESSOA_FISICA(1, "Pessoas física"), PESSOA_JURIDICA(1, "Pessoa Jurídica"){
        public String getid(){
            return "B";
        }
    };

    private int tipo;
    private String nome;

    TipoCliente(int tipo, String nome) {
        this.tipo = tipo;
        this.nome = nome;

    }
    // constant specific class body

    public String getid(){
        return "A";
    }
    public String getNome() {
        return nome;
    }

    public int getTipo() {
        return tipo;
    }
}
