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
    private String id;
    private Long maquinaID;
    private LocalDate data;
    private String tipo;
    private String pecasTrocadas;
    private Long tempoDeParada;
    private String tecnicoID;
    private String observacoes;
}
