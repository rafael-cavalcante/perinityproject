package com.rafaelcavalcante.perinityproject.service;

import com.rafaelcavalcante.perinityproject.model.Tarefa;

import java.util.List;

public interface TarefaService {
    Tarefa adicionarTarefa(Tarefa tarefa);
    List<Tarefa> listarTarefasPendentes();
    Tarefa alocarPessoaTarefa(Long pessoaId, Long tarefaId);
    Tarefa finalizarTarefa(Long id);
}
