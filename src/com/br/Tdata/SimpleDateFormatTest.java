package com.br.Tdata;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SimpleDateFormatTest {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        String mascara = " 'Atlanta, ' dd, 'de' MMMM 'de' yyyy ";
        SimpleDateFormat data = new SimpleDateFormat(mascara);
        System.out.println(data.format(c.getTime()));

    }
}
