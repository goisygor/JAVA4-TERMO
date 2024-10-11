package com.example.models;

import java.time.LocalDate;

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
    private LocalDate data;
    private String problema;
    private String prioridade;
    private String operador;
}
