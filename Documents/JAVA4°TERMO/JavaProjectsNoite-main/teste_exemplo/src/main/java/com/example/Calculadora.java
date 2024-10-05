package com.example;

public class Calculadora {
    //soma
    public double soma( double a, double b){
        return a + b;
    }
    //subtrai
    public double subtrai( double a, double b){
        return a - b;
    }
    //multiplica
    public double multiplica( double a, double b){
        return a * b;
    }
    //divide
    public double divide( double a, double b){
        if(b == 0){
            throw new ArithmeticException("Não é possível dividir por zero");
        }
        return a / b;
    }
}
