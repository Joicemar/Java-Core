package com.br.Tdata;

import java.util.Calendar;
import java.util.Date;

public class ManipulaDataTest {
    public static void main(String[] args) {
        Date data = new Date(1000000000_000L); //passamos a data em milessegundos
        System.out.println(data);

        Calendar c = Calendar.getInstance();

        c.setTime(data);
        if(Calendar.SUNDAY == c.getFirstDayOfWeek());
        System.out.println("Domingo é o primeiro dia da semana");

        System.out.println(c.get(Calendar.DAY_OF_MONTH));
        System.out.println(c.get(java.util.Calendar.DAY_OF_WEEK));
        System.out.println(c.get(java.util.Calendar.DAY_OF_YEAR));

        c.add(Calendar.HOUR, 3);
        c.roll(Calendar.MONTH, 11);
        Date date2 = c.getTime();
        System.out.println(date2);

        //NumberFormat, Locale, Calendar, Date, DateFormat.
    }
}
