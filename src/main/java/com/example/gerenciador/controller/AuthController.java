package com.example.gerenciador.controller;

import com.example.gerenciador.model.UsuarioModel;
import com.example.gerenciador.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/register")
    public ResponseEntity<?> registrarUsuario(@RequestBody UsuarioModel usuario) {
        if (usuarioRepository.findByUsername(usuario.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Usuário já existe");
        }

        UsuarioModel novoUsuario = usuarioRepository.save(usuario);
        return ResponseEntity.ok(novoUsuario);
    }
}
