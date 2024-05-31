package com.rafaelcavalcante.perinityproject.service;

import com.rafaelcavalcante.perinityproject.model.Tarefa;

import java.util.List;

public interface TarefaService {
    Tarefa adicionarTarefa(Tarefa tarefa);
    List<Tarefa> listarTarefasPendentes();
    Tarefa alocarPessoaTarefa(Long tarefaId, Long pessoaId);
    Tarefa finalizarTarefa(Long id);
}
