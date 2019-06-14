package com.br.Sstrings.test;

public class StringBuilderTeste {
    public static void main(String[] args) {
        String s = "34255206";
        StringBuilder ab = new StringBuilder();
        ab.append("der").insert(3,"####").reverse().delete(1,3);
        System.out.println(ab);
    }

}
