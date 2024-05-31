package com.rafaelcavalcante.perinityproject.config;

import com.rafaelcavalcante.perinityproject.model.Departamento;
import com.rafaelcavalcante.perinityproject.model.Pessoa;
import com.rafaelcavalcante.perinityproject.model.Tarefa;
import com.rafaelcavalcante.perinityproject.repository.DepartamentoRepository;
import com.rafaelcavalcante.perinityproject.repository.PessoaRepository;
import com.rafaelcavalcante.perinityproject.repository.TarefaRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class Config {
    private PessoaRepository PessoaRepository;
    private TarefaRepository tarefaRepository;
    private DepartamentoRepository departamentoRepository;

    public Config(PessoaRepository pessoaRepository, TarefaRepository tarefaRepository, DepartamentoRepository departamentoRepository) {
        this.PessoaRepository = pessoaRepository;
        this.tarefaRepository = tarefaRepository;
        this.departamentoRepository = departamentoRepository;
    }

    @PostConstruct
    public void start(){
        if(this.PessoaRepository.count() == 0){
            Pessoa pessoa1 = new Pessoa(null, "Rafael", null, null);
            Pessoa pessoa2 = new Pessoa(null, "Jose", null, null);

            this.PessoaRepository.saveAll(List.of(pessoa1, pessoa2));
        }

        if(this.tarefaRepository.count() == 0){
            Tarefa tarefa1 = new Tarefa(null, "Tarefa 01", "Contruir o crud 01", LocalDate.of(2024, 5, 30), 10, false, null, null);
            Tarefa tarefa2 = new Tarefa(null, "Tarefa 02", "Contruir o crud 02", LocalDate.of(2023, 6, 20), 20, false, null, null);
            Tarefa tarefa3 = new Tarefa(null, "Tarefa 03", "Contruir o crud 03", LocalDate.of(2022, 1, 10), 7, false, null, null);

            this.tarefaRepository.saveAll(List.of(tarefa1, tarefa2, tarefa3));
        }

        if(this.departamentoRepository.count() == 0){
            Departamento departamento1 = new Departamento(null, "TI");
            Departamento departamento2 = new Departamento(null, "RH");

            this.departamentoRepository.saveAll(List.of(departamento1, departamento2));
        }
    }
}
