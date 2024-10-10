package com.example.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Manutencao {
    public Manutencao(String string, int int1, String string2, String string3, String string4, String string5,
            String string6, String string7) {
        //TODO Auto-generated constructor stub
    }
    private String id;
    private Long maquinaID;
    private LocalDate data;
    private String tipo;
    private String pecasTrocadas;
    private Long tempoDeParada;
    private String tecnicoID;
    private String observacoes;
}
