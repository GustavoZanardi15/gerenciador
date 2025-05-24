package com.example.gerenciador.controller;

import com.example.gerenciador.dto.LoginRequest;
import com.example.gerenciador.model.UsuarioModel;
import com.example.gerenciador.repository.UsuarioRepository;
import com.example.gerenciador.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtUtil jwtUtil;


    @PostMapping("/register")
    public ResponseEntity<?> registrarUsuario(@RequestBody UsuarioModel usuario) {
        if (usuarioRepository.findByUsername(usuario.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Usuário já existe");
        }

        UsuarioModel novoUsuario = usuarioRepository.save(usuario);
        return ResponseEntity.ok(novoUsuario);
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest login) {

        return usuarioRepository.findByUsername(login.getUsername())
                .map(usuario -> {

                    if (usuario.getPassword().equals(login.getPassword())) {

                        String token = jwtUtil.generateToken(usuario.getUsername());


                        return ResponseEntity.ok("Bearer " + token);
                    }


                    return ResponseEntity.status(401).body("Senha inválida");
                })

                .orElse(ResponseEntity.status(401).body("Usuário não encontrado"));
    }
}
