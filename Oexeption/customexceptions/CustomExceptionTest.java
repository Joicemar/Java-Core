package com.br.Oexeption.customexceptions;

public class CustomExceptionTest {
    public static void main(String[] args) {
        try {
            loginUsuario();
        } catch (com.br.Oexeption.checkedExeption.teste.LoginInvalidoExeption e) {
            e.printStackTrace();
        }
    }

    public static void loginUsuario() throws com.br.Oexeption.checkedExeption.teste.LoginInvalidoExeption {
        String nomeBancoDeDados = "Goku";
        String senhaBancoDeDados = "123";
        String usuarioDigitado = "Goku";
        String senhaDigitada = "111";
        if(!nomeBancoDeDados.equals(usuarioDigitado) || !senhaBancoDeDados.equals(senhaDigitada)){
            throw new com.br.Oexeption.checkedExeption.teste.LoginInvalidoExeption();
        }else{
            System.out.println("Logado");
        }
    }
}
