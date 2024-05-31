package com.rafaelcavalcante.perinityproject.service.implement;

import com.rafaelcavalcante.perinityproject.config.exception.ResourceNotFoundException;
import com.rafaelcavalcante.perinityproject.model.Pessoa;
import com.rafaelcavalcante.perinityproject.model.Tarefa;
import com.rafaelcavalcante.perinityproject.model.dto.PessoaGastosDTO;
import com.rafaelcavalcante.perinityproject.model.dto.PessoaMediaGastosDTO;
import com.rafaelcavalcante.perinityproject.repository.PessoaRepository;
import com.rafaelcavalcante.perinityproject.service.PessoaService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class PessoaServiceImplement implements PessoaService {
    private PessoaRepository pessoaRepository;

    public PessoaServiceImplement(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public Pessoa adicionarPessoa(Pessoa pessoa) {
        return this.pessoaRepository.save(pessoa);
    }

    @Override
    public List<PessoaGastosDTO> listarPessoas() {
        return this.pessoaRepository.findAll().stream().map(pessoa -> {
            int totalHoras = pessoa.getTarefas().stream().mapToInt(Tarefa::getDuracao).sum();
            return new PessoaGastosDTO(pessoa.getNome(), pessoa.getDepartamento(), totalHoras);
        }).collect(Collectors.toList());
    }

    @Override
    public Pessoa atualizarPessoa(Long id, Pessoa pessoa) {
        Optional<Pessoa> optionalPessoa = this.pessoaRepository.findById(id);

        if (optionalPessoa.isPresent()) {
            Pessoa pessoaExistente = optionalPessoa.get();
            pessoaExistente.setNome(pessoa.getNome());
            pessoaExistente.setDepartamento(pessoa.getDepartamento());
            pessoaExistente.setTarefas(pessoa.getTarefas());

            return this.pessoaRepository.save(pessoaExistente);
        } else {
            throw new ResourceNotFoundException("Pessoa não encontrada com id " + id);
        }
    }

    @Override
    public void deletarPessoa(Long id) {
        Optional<Pessoa> optionalPessoa = this.pessoaRepository.findById(id);

        if (optionalPessoa.isPresent()) {
            this.pessoaRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Pessoa não encontrada com id " + id);
        }
    }

    @Override
    public List<PessoaMediaGastosDTO> buscarPessoaNomePeriodo(String nome, LocalDate dataInicio, LocalDate dataFim) {
        return this.pessoaRepository.findPessoaHorasByNomeAndPeriodo(nome, dataInicio, dataFim);
    }
}
