package com.br.Oexeption.checkedExeption.classes;

import com.br.Oexeption.checkedExeption.teste.LoginInvalidoExeption;

import java.io.FileNotFoundException;

public class Pessoa {
    public void salvar() throws LoginInvalidoExeption, FileNotFoundException{
        System.out.println("Salvando");
    }
}
