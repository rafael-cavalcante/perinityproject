package com.rafaelcavalcante.perinityproject.controller;

import com.rafaelcavalcante.perinityproject.model.Pessoa;
import com.rafaelcavalcante.perinityproject.model.dto.PessoaGastosDTO;
import com.rafaelcavalcante.perinityproject.model.dto.PessoaMediaGastosDTO;
import com.rafaelcavalcante.perinityproject.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    private PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    public ResponseEntity<Pessoa> adicionarPessoa(@RequestBody Pessoa pessoa) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.pessoaService.adicionarPessoa(pessoa));
    }

    @GetMapping
    public ResponseEntity<List<PessoaGastosDTO>> listarPessoas() {
        return ResponseEntity.ok().body(this.pessoaService.listarPessoas());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        return ResponseEntity.ok().body(this.pessoaService.atualizarPessoa(id, pessoa));
    }

    @DeleteMapping("/{id}")
    public void deletarPessoa(@PathVariable Long id) {
        this.pessoaService.deletarPessoa(id);
    }

    @GetMapping("/gastos")
    public ResponseEntity<List<PessoaMediaGastosDTO>> buscarPessoaNomePeriodo(@RequestParam String nome, @RequestParam String dataInicio,
                                                                              @RequestParam String dataFim) {
        LocalDate inicioPeriodo = LocalDate.parse(dataInicio);
        LocalDate fimPeriodo = LocalDate.parse(dataFim);

        return ResponseEntity.ok().body(this.pessoaService.buscarPessoaNomePeriodo(nome, inicioPeriodo, fimPeriodo));
    }
}
