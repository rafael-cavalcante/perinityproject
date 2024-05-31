package com.rafaelcavalcante.perinityproject.service;

import com.rafaelcavalcante.perinityproject.model.Departamento;
import com.rafaelcavalcante.perinityproject.model.dto.DepartamentoDTO;

import java.util.List;

public interface DepartamentoService {
    Departamento adicionarDepartamento(Departamento departamento);
    List<DepartamentoDTO> listarDepartamentos();
    Departamento atualizarDepartamento(Long id,Departamento departamento);
    void deletarDepartamento(Long id);
}