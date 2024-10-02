package com.example;

public class Main {
    public static void main(String[] args) {
        UsuarioController uc = new UsuarioController();
        uc.createUser(new Usuario("null", "Pedro", 35, "Rua Brasil"));
        uc.read();
       
    }
}