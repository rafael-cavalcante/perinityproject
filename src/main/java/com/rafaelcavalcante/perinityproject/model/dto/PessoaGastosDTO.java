package com.rafaelcavalcante.perinityproject.model.dto;

import com.rafaelcavalcante.perinityproject.model.Departamento;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PessoaGastosDTO {
    private String nome;
    private Departamento departamento;
    private int totalHoras;
}
