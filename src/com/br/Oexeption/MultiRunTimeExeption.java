package com.br.Oexeption;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class MultiRunTimeExeption {

    public static void main(String[] args) {
        try{
            throw new IndexOutOfBoundsException();
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Dentro de ArrayIndexOutOfBoundsException");
        }catch (IndexOutOfBoundsException | IllegalArgumentException | ArithmeticException e) {
            System.out.println("Dentro de IndexOutOfBoundsException");
        }
        /*
        catch (IllegalArgumentException e){
            System.out.println("Dentro de IllegalArgumentException");
        }catch (ArithmeticException e){
            System.out.println("Dentro do ArithmeticException");
        }*/
        System.out.println("Final do programa");
        try {
            talvezLanceExeption();
        }catch(SQLException | AWTException | FileNotFoundException e){

        }catch(Exception e){} //Ou so este para todas os exceptions.
    }

    private static void talvezLanceExeption() throws SQLException, AWTException, FileNotFoundException{

    }
}
