package com.rafaelcavalcante.perinityproject.repository;

import com.rafaelcavalcante.perinityproject.model.Departamento;
import com.rafaelcavalcante.perinityproject.model.dto.DepartamentoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    @Query("SELECT new com.rafaelcavalcante.perinityproject.model.dto.DepartamentoDTO(d.id, d.nome, COUNT(DISTINCT p.id), COUNT(DISTINCT t.id)) " +
            "FROM Departamento d " +
            "LEFT JOIN Pessoa p ON d.id = p.departamento.id " +
            "LEFT JOIN Tarefa t ON d.id = t.departamento.id " +
            "GROUP BY d.id, d.nome")
    List<DepartamentoDTO> findDepartamentosStats();
}
