package com.rafaelcavalcante.perinityproject.controller;

import com.rafaelcavalcante.perinityproject.model.Departamento;
import com.rafaelcavalcante.perinityproject.model.dto.DepartamentoDTO;
import com.rafaelcavalcante.perinityproject.service.DepartamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {
    private DepartamentoService departamentoService;

    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @PostMapping
    public ResponseEntity<Departamento> adicionarDepartamento(Departamento departamento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.departamentoService.adicionarDepartamento(departamento));
    }

    @GetMapping
    public ResponseEntity<List<DepartamentoDTO>> listarDepartamentos() {
        return ResponseEntity.ok(this.departamentoService.listarDepartamentos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Departamento> atualizarDepartamento(@PathVariable Long id,Departamento departamento) {
        return ResponseEntity.ok().body(this.departamentoService.atualizarDepartamento(id, departamento));
    }

    @DeleteMapping
    public void deletarDepartamento(@PathVariable Long id) {
        this.departamentoService.deletarDepartamento(id);
    }
}
