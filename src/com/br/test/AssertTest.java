package com.br.passertions.test;

public class AssertTest {
    public static void main(String[] args) {
        calcularSalario(-1000);
    }
    //O metodo fora do main deve ser estatico para iniciar os valores em memoria a tempo
    public static void calcularSalario(double salario){
        assert (salario > 0):"O salario e menor que 0, veio o valor de : "+salario;
        // calculo salario
    }

    public static void calcularlasario2(double salario){
        if(salario < 0){
            throw new IllegalArgumentException();
        }
    }
}
