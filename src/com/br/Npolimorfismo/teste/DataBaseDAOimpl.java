package com.br.Npolimorfismo.teste;

import  com.br.Npolimorfismo.GenericDAO;

public class DataBaseDAOimpl implements GenericDAO {

    @Override
    public void save() {
        System.out.println("Salvando dados no Banco de Dados");
    }
}
