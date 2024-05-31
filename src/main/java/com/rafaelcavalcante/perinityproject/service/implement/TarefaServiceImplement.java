package com.rafaelcavalcante.perinityproject.service.implement;

import com.rafaelcavalcante.perinityproject.config.exception.ResourceNotEqualException;
import com.rafaelcavalcante.perinityproject.config.exception.ResourceNotFoundException;
import com.rafaelcavalcante.perinityproject.model.Pessoa;
import com.rafaelcavalcante.perinityproject.model.Tarefa;
import com.rafaelcavalcante.perinityproject.repository.PessoaRepository;
import com.rafaelcavalcante.perinityproject.repository.TarefaRepository;
import com.rafaelcavalcante.perinityproject.service.TarefaService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TarefaServiceImplement implements TarefaService {
    private TarefaRepository tarefaRepository;
    private PessoaRepository pessoaRepository;

    public TarefaServiceImplement(TarefaRepository tarefaRepository, PessoaRepository pessoaRepository) {
        this.tarefaRepository = tarefaRepository;
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public Tarefa adicionarTarefa(Tarefa tarefa) {
        return this.tarefaRepository.save(tarefa);
    }

    @Override
    public List<Tarefa> listarTarefasPendentes() {
        return this.tarefaRepository.findTop3ByPessoaIsNullOrderByPrazoAsc();
    }

    @Override
    public Tarefa alocarPessoaTarefa(Long pessoaId, Long tarefaId) {
        Tarefa tarefa = this.tarefaRepository.findById(tarefaId)
                .orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada"));
        Pessoa pessoa = this.pessoaRepository.findById(pessoaId)
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada"));

        if (!tarefa.getDepartamento().equals(pessoa.getDepartamento())) {
            throw new ResourceNotEqualException("Pessoa e tarefa devem pertencer ao mesmo departamento");
        }

        tarefa.setPessoa(pessoa);
        return this.tarefaRepository.save(tarefa);
    }

    @Override
    public Tarefa finalizarTarefa(Long id) {
        Tarefa tarefa = this.tarefaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada com id " + id));;

        if (tarefa.isFinalizada()) {
            throw new ResourceNotEqualException("Tarefa finalizada!");
        } else {
            tarefa.setFinalizada(true);
            return this.tarefaRepository.save(tarefa);
        }
    }
}
