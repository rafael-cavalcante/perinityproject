package com.rafaelcavalcante.perinityproject.controller;

import com.rafaelcavalcante.perinityproject.model.Tarefa;
import com.rafaelcavalcante.perinityproject.service.TarefaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    private TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public ResponseEntity<Tarefa> adicionarTarefa(@RequestBody Tarefa tarefa) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.tarefaService.adicionarTarefa(tarefa));
    }

    @GetMapping("/pendentes")
    public ResponseEntity<List<Tarefa>> listarTarefasPendentes() {
        return ResponseEntity.ok().body(this.tarefaService.listarTarefasPendentes());
    }

    @PutMapping("/finalizar/{id}")
    public ResponseEntity<Tarefa> finalizarTarefa(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.tarefaService.finalizarTarefa(id));
    }

    @PutMapping("/{pessoaId}/alocar/{tarefaId}")
    public ResponseEntity<Tarefa> alocarPessoaTarefa(@PathVariable Long pessoaId, @PathVariable Long tarefaId) {
        return ResponseEntity.ok().body(this.tarefaService.alocarPessoaTarefa(pessoaId, tarefaId));
    }
}
