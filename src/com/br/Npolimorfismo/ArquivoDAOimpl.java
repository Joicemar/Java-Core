package com.br.Npolimorfismo;

public class ArquivoDAOimpl implements com.br.Npolimorfismo.GenericDAO{
    @Override
    public void save() {
        System.out.println("Salvando dados nos arquivos");
    }
}
