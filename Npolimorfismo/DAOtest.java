package com.br.Npolimorfismo;

import com.br.Npolimorfismo.teste.DataBaseDAOimpl;

import java.util.ArrayList;
import java.util.List;

public class DAOtest {
    public static void main(String[] args) {
        GenericDAO arquivoDAO = new DataBaseDAOimpl();
        arquivoDAO.save();
        List<String> lista = new ArrayList<>();
        lista.add("nome1");
        lista.add("nome2");
        lista.add("nome3");
        lista.add("nome4");
        for(String nome: lista){
            System.out.println(nome);
        }
    }
}
