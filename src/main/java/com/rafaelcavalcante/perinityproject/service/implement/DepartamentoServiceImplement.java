package com.rafaelcavalcante.perinityproject.service.implement;

import com.rafaelcavalcante.perinityproject.config.exception.ResourceNotFoundException;
import com.rafaelcavalcante.perinityproject.model.Departamento;
import com.rafaelcavalcante.perinityproject.model.dto.DepartamentoDTO;
import com.rafaelcavalcante.perinityproject.repository.DepartamentoRepository;
import com.rafaelcavalcante.perinityproject.service.DepartamentoService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DepartamentoServiceImplement implements DepartamentoService {
    private DepartamentoRepository departamentoRepository;

    public DepartamentoServiceImplement(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    @Override
    public Departamento adicionarDepartamento(Departamento departamento) {
        return this.departamentoRepository.save(departamento);
    }

    @Override
    public List<DepartamentoDTO> listarDepartamentos() {
        return this.departamentoRepository.findDepartamentosStats();
    }

    @Override
    public Departamento atualizarDepartamento(Long id, Departamento departamento) {
        Optional<Departamento> optionalDepartamento = this.departamentoRepository.findById(id);

        if (optionalDepartamento.isPresent()) {
            Departamento departamentoExistente = optionalDepartamento.get();
            departamentoExistente.setNome(departamento.getNome());

            return this.departamentoRepository.save(departamentoExistente);
        } else {
            throw new ResourceNotFoundException("Departamento não encontrada com id " + id);
        }
    }

    @Override
    public void deletarDepartamento(Long id) {
        Optional<Departamento> optionalDepartamento = this.departamentoRepository.findById(id);

        if (optionalDepartamento.isPresent()) {
            this.departamentoRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Departamento não encontrada com id " + id);
        }
    }
}
