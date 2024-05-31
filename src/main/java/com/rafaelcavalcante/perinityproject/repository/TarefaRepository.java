package com.rafaelcavalcante.perinityproject.repository;

import com.rafaelcavalcante.perinityproject.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    List<Tarefa> findTop3ByPessoaIsNullOrderByPrazoAsc();
}
