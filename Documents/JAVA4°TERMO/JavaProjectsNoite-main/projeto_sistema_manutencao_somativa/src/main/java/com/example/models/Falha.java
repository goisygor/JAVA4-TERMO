package com.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Falha {
    private String id;
    private Long maquinaID;
    private String data;
    private String problema;
    private String prioridade;
    private String operador;
}
