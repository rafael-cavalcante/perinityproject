package com.rafaelcavalcante.perinityproject.repository;

import com.rafaelcavalcante.perinityproject.model.Pessoa;
import com.rafaelcavalcante.perinityproject.model.dto.PessoaMediaGastosDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    @Query("SELECT new com.rafaelcavalcante.perinityproject.model.dto.PessoaMediaGastosDTO(p.id, p.nome, AVG(t.duracao)) " +
            "FROM Pessoa p " +
            "JOIN p.tarefas t " +
            "WHERE p.nome LIKE %:nome% " +
            "AND t.prazo >= :dataInicio " +
            "AND t.prazo <= :dataFim " +
            "GROUP BY p.id, p.nome")
    List<PessoaMediaGastosDTO> findPessoaHorasByNomeAndPeriodo(@Param("nome") String nome,
                                                               @Param("dataInicio") LocalDate dataInicio,
                                                               @Param("dataFim") LocalDate dataFim);
}
