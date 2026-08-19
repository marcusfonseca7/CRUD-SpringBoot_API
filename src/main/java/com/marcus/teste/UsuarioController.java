package com.marcus.teste;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    ArrayList<Usuario> usuarios = new ArrayList<>();

    @GetMapping
    public ArrayList<Usuario> listarTodosUsuarios() {
        return usuarios;
    }

    @PostMapping
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario) {
        usuarios.add(usuario);
        return usuarios.getLast();
    }

    @PutMapping("/{id}")
    public Usuario atualizarUsuario(@PathVariable int id, @RequestBody Usuario usuario){
        Usuario usuarioAtualizado = usuarios.get(id);

        usuarioAtualizado.setNome(usuario.getNome());
        usuarioAtualizado.setCpf(usuario.getCpf());
        usuarioAtualizado.setEmail(usuario.getEmail());

        return usuarioAtualizado;
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable int id) {
        usuarios.remove(id);
    }

}
