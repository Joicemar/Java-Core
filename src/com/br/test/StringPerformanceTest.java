package com.br.Sstrings.test;

public class StringPerformanceTest {
    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        concatString(5000);
        long fim = System.currentTimeMillis();
        System.out.println("Tempo gasto ="+(fim - inicio) + " ms");

        inicio = System.currentTimeMillis();
        concatstringBuilder(5000);
        fim = System.currentTimeMillis();
        System.out.println("Tempo gasto ="+(fim - inicio) + " ms");

        inicio = System.currentTimeMillis();
        concatstringBuffer(5000);
        fim = System.currentTimeMillis();
        System.out.println("Tempo gasto ="+(fim - inicio) + " ms");

    }

    public static void concatString(int tan){
        String string = "";
        for(int i = 0; i < tan; i++){
            string += i;
        }
    }
    public static void concatstringBuilder(int tan){
        StringBuilder bs = new StringBuilder(tan);
        for(int i = 0; tan > i; i++){
            bs.append(i);
        }
    }
    public static void concatstringBuffer(int tam){
        StringBuffer ab = new StringBuffer(tam);
        for(int i = 0; tam > i; i++){
            ab.append(tam);
        }
        //System.out.println(ab.substring(0,7));
    }
}
