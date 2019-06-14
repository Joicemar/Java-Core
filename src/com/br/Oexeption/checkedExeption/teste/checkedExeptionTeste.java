package com.br.Oexeption.checkedExeption.teste;

import java.io.File;
import java.io.IOException;

public class checkedExeptionTeste {
    public static void main(String[] args) {

        abrirArquivo();
    }

    public static void criarArquivo()throws IOException {
        File file = new File("Test.txt");

        try {
            System.out.println("Arquivo criado? :" + file.createNewFile());
            System.out.println("Arquivo criado.");
        } catch (IOException e) {
            //printa as pilhas de erros
            e.printStackTrace();
            throw e;
        }
    }

    public static void abrirArquivo(){
        try{
            System.out.println("Abrir arquivo");
            System.out.println("Ler arquivo.");
            //throw new Exception();
        }catch(Exception e){
            //printa as pilhas de erros
            e.printStackTrace();
            //throw e;
        }finally {
            System.out.println("Fechar arquivo ");
        }

    }
}
