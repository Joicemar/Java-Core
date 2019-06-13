package com.br.modificadorFinal.test;

import com.br.modificadorFinal.classes.Carro;

public class CarroTest {
    public static void main(String[] args) {
        Carro c = new Carro();
        System.out.println(c.getComprador());
        c.getComprador().setNome("Juan");
        System.out.println(c.getComprador());

    }
}
