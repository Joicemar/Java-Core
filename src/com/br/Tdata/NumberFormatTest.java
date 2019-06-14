package com.br.Tdata;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatTest {
    public static void main(String[] args) {
        float valor = 132.4756f;
        Locale locJP = new Locale("JP");
        Locale locFR = new Locale("FR");
        Locale locIT = new Locale("IT");
        Locale locBR = new Locale("BR");

        NumberFormat nft[] = new NumberFormat[6];
        nft[0] = NumberFormat.getInstance();
        nft[1] = NumberFormat.getInstance(locIT);
        nft[2] = NumberFormat.getCurrencyInstance();
        nft[3] = NumberFormat.getCurrencyInstance(locIT);
        nft[4] = NumberFormat.getCurrencyInstance(locBR);
        nft[5] = NumberFormat.getInstance(locBR);
        for(NumberFormat nf: nft){
            System.out.println(nf.format(valor));
        }
        NumberFormat nf = NumberFormat.getInstance();
        System.out.println(nf.getMaximumFractionDigits());
        nf.setMaximumFractionDigits(1); //printa uma casa depois da virgula como passado no parametro
        System.out.println(nf.format(valor));
        String valorString = "129034";
        try {
            System.out.println(nf.parse(valorString));
            nf.setParseIntegerOnly(true);
            System.out.println(nf.parse(valorString));
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
    }
}
