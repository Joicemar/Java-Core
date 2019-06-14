package com.br.Tdata;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

public class LocalTest {
    public static void main(String[] args) {
        Locale looItaly = new Locale("it", "IT");
        Locale looSuica = new Locale("it", "CH");
        Locale looIndia = new Locale("hi", "IN");
        Locale looJapao = new Locale("ja");

        Calendar c = Calendar.getInstance();
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, looItaly);
        DateFormat df2 = DateFormat.getDateInstance(DateFormat.FULL, looSuica);
        DateFormat df3 = DateFormat.getDateInstance(DateFormat.FULL, looIndia);
        DateFormat df4 = DateFormat.getDateInstance(DateFormat.FULL, looJapao);

        System.out.println("Italia " + df.format(c.getTime()));
        System.out.println("SuiÃ§a " + df2.format(c.getTime()));
        System.out.println("India " + df3.format(c.getTime()));
        System.out.println("JapÃ£o " + df4.format(c.getTime())); //JapÃƒÂ£o 2018å¹´10æœˆ12æ—¥é‡‘æ›œæ—¥
        //1.000,00 , 1,000.00
        System.out.println(looItaly.getDisplayLanguage(looItaly)); //italiano
        System.out.println(looIndia.getDisplayLanguage(looIndia)); //à¤¹à¤¿à¤¨à¥�à¤¦à¥€
        System.out.println(looSuica.getDisplayCountry(looJapao));  //ã‚¹ã‚¤ã‚¹
    }
}
