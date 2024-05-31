package com.rafaelcavalcante.perinityproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tarefas")
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate prazo;
    private Integer duracaoH;
    private String status;
    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
}
