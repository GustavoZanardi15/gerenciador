package com.example.gerenciador.controller;

import com.example.gerenciador.model.TarefaModel;
import com.example.gerenciador.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<TarefaModel> criarTarefa(@RequestBody TarefaModel tarefa) {
        return ResponseEntity.ok(tarefaService.criarTarefa(tarefa));
    }

    @GetMapping
    public ResponseEntity<List<TarefaModel>> listarTarefas() {
        return ResponseEntity.ok(tarefaService.listarTarefas());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaModel> atualizarTarefa(
            @PathVariable Long id,
            @RequestBody TarefaModel tarefa
    ) {
        return ResponseEntity.ok(tarefaService.atualizarTarefa(id, tarefa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
        tarefaService.deletarTarefa(id);
        return ResponseEntity.noContent().build();
    }
}
