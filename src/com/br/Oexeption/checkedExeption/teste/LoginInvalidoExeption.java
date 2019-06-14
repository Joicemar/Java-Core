package com.br.Oexeption.checkedExeption.teste;

public class LoginInvalidoExeption extends Exception{
    public LoginInvalidoExeption(){
        System.out.println("Login ou Usuario Invalidos.");
    }
}
