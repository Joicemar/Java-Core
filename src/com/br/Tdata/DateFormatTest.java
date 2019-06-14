package com.br.Tdata;

import java.text.DateFormat;
import java.util.Calendar;

import static java.text.DateFormat.*;

public class DateFormatTest {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        DateFormat[] df = new DateFormat[6];
        df[0] = getInstance();
        df[1] = getDateInstance();
        df[2] = getDateInstance(DateFormat.SHORT);
        df[3] = getDateInstance(DateFormat.MEDIUM);
        df[4] = getDateInstance(DateFormat.LONG);
        df[5] = getDateInstance(DateFormat.FULL);
        //df[6] = getDateInstance(java.text.DateFormat.AM_PM_FIELD);

        for(DateFormat dfa : df){
            System.out.println(dfa.format(c.getTime()));
        }
    }

}
