package com.marcus.teste.interface_ui.controller;

import com.marcus.teste.application.service.UsuarioService;
import com.marcus.teste.domain.repository.UsuarioRepository;
import com.marcus.teste.domain.entity.Usuario;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {

    final UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listarTodosUsuarios() {
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public Usuario buscarUsuarioPorId(@PathVariable UUID id) {
        return usuarioService.findById(id);
    }

    @PostMapping
    public Usuario cadastrarUsuarios(@Valid @RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    @PutMapping("/{id}")
    public Usuario atualizarUsuario(@Valid @PathVariable UUID id, @RequestBody Usuario usuario){
        return usuarioService.update(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable UUID id) {
        usuarioService.deleteById(id);
    }

}
