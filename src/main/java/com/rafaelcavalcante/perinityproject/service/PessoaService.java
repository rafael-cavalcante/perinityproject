package com.rafaelcavalcante.perinityproject.service;

import com.rafaelcavalcante.perinityproject.model.Pessoa;
import com.rafaelcavalcante.perinityproject.model.dto.PessoaGastosDTO;
import com.rafaelcavalcante.perinityproject.model.dto.PessoaMediaGastosDTO;

import java.time.LocalDate;
import java.util.List;

public interface PessoaService {
    Pessoa adicionarPessoa(Pessoa pessoa);
    List<PessoaGastosDTO> listarPessoas();
    Pessoa atualizarPessoa(Pessoa pessoa, Long id);
    List<PessoaMediaGastosDTO> buscarPessoaNomePeriodo(String nome, LocalDate dataInicio, LocalDate dataFim);
    void deletarPessoa(Long id);
}
