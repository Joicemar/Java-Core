package com.br.Sstrings.test;

public class StringsTest {
    public static void main(String[] args) {
        String nome = "joao";
        nome = nome.concat(" Silva");
        String nome1 = new String("Silva");
        String nome2 = new String("  Paloma   ");

        String teste = "Goku";
        String teste2 = "goku";
        System.out.println(teste.charAt(2));
        System.out.println(teste.equalsIgnoreCase(teste2));
        System.out.println(teste.length());
        System.out.println(teste.replace("o","a"));
        System.out.println(teste.toUpperCase());
        System.out.println(teste.toLowerCase());
        System.out.println(teste.substring(1,4));
        System.out.println(teste.substring(2));
        System.out.println(nome2.trim());
    }
}
