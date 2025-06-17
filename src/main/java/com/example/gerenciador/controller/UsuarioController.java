package com.example.gerenciador.controller;

import com.example.gerenciador.model.UsuarioModel;
import com.example.gerenciador.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UsuarioModel>> listarUsuarios() {
        List<UsuarioModel> usuarios = usuarioRepository.findAll();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/me")
    public ResponseEntity<?> verMeuPerfil(@AuthenticationPrincipal UsuarioModel usuario) {
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/me")
    public ResponseEntity<?> atualizarMeuPerfil(@AuthenticationPrincipal UsuarioModel usuarioLogado,
                                                @RequestBody UsuarioModel novosDados) {
        usuarioLogado.setNome(novosDados.getNome());
        usuarioLogado.setEmail(novosDados.getEmail());
        usuarioLogado.setPassword(novosDados.getPassword()); // ⚠️ Criptografar futuramente

        UsuarioModel atualizado = usuarioRepository.save(usuarioLogado);
        return ResponseEntity.ok(atualizado);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> visualizarUsuarioPorId(@PathVariable Long id) {
        return usuarioRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> atualizarUsuario(@PathVariable Long id,
                                              @RequestBody UsuarioModel dadosAtualizados) {
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    usuario.setNome(dadosAtualizados.getNome());
                    usuario.setEmail(dadosAtualizados.getEmail());
                    usuario.setPassword(dadosAtualizados.getPassword());
                    usuario.setUsername(dadosAtualizados.getUsername());
                    usuario.setRole(dadosAtualizados.getRole());

                    UsuarioModel atualizado = usuarioRepository.save(usuario);
                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deletarUsuario(@PathVariable Long id) {
        if (!usuarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        usuarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
