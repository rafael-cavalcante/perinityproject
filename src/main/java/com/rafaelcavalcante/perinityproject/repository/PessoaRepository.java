package com.rafaelcavalcante.perinityproject.repository;

import com.rafaelcavalcante.perinityproject.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
