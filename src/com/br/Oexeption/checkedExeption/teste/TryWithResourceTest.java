package com.br.Oexeption.checkedExeption.teste;

import com.br.Oexeption.checkedExeption.classes.Leitor1;
import com.br.Oexeption.checkedExeption.classes.Leitor2;
import java.io.Reader;

public class TryWithResourceTest {

    public static void main(String[] args) {
        lerArquivo();
    }
    public static void lerArquivo() {
        //try (Reader reader = new BufferedReader(new java.io.FileReader("text.txt"))) {
        try (Leitor2 ler2 = new Leitor2();
            Leitor1 ler1 = new Leitor1()) {

        } catch (Exception e) {
            System.out.println("catch...");
            e.printStackTrace();

        }
    }
    public static void lerArquivood () {
        Reader reader = null;
        try {
            reader = new java.io.BufferedReader(new java.io.FileReader("text.txt")); } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
    }

}
