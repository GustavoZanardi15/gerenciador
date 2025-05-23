package com.example.gerenciador.service;

import com.example.gerenciador.model.TarefaModel;
import com.example.gerenciador.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public TarefaModel criarTarefa(TarefaModel tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public List<TarefaModel> listarTarefas() {
        return tarefaRepository.findAll();
    }

    public Optional<TarefaModel> buscarPorId(Long id) {
        return tarefaRepository.findById(id);
    }

    public TarefaModel atualizarTarefa(Long id, TarefaModel novaTarefa) {
        return tarefaRepository.findById(id)
                .map(tarefa -> {
                    tarefa.setTitulo(novaTarefa.getTitulo());
                    tarefa.setDescricao(novaTarefa.getDescricao());
                    tarefa.setStatus(novaTarefa.getStatus());
                    return tarefaRepository.save(tarefa);
                })
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada com id: " + id));
    }

    public void deletarTarefa(Long id) {
        tarefaRepository.deleteById(id);
    }
}
