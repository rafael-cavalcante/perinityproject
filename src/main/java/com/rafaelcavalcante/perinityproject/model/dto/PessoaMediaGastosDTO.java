package com.rafaelcavalcante.perinityproject.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PessoaMediaGastosDTO {
    private Long id;
    private String nome;
    private Double mediaHorasGastas;
}
