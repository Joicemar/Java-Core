package com.br.Oexeption.runtimeExeption.test;

public class RuntimeExeptionTest {
    public static void main(String[] args) {
        try{
            divisao(2, 0);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
    public static void divisao(int num1, int num2){
        if(num2 == 0){
            throw new IllegalArgumentException("passe um numero diferente de 0 para num2");
        }
        System.out.println(num1/num2);
    }
}
