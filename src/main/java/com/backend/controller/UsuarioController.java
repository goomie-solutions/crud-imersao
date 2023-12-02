package com.backend.controller;


import com.backend.entidades.Usuario;
import com.backend.servicos.UsuarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServico servico;


    // Consulta por id
    @GetMapping("/{id}") //localhost:8080/usuarios/1
    public ResponseEntity<Usuario> buscaPorId(@PathVariable Long id) {

        Usuario resposta = servico.consultaUsuario(id);
        return ResponseEntity.ok().body(resposta);
    }

    // Criação do usuário no banco
    @PostMapping("/criar")
    public ResponseEntity<Usuario> criaUsuario(@RequestBody Usuario requisicao) {
        Usuario resposta = servico.criaUsuario(requisicao);
        return ResponseEntity.ok().body(resposta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletaUsuario(@PathVariable Long id) {
        servico.deletaUsuario(id);
        return ResponseEntity.ok().body("Usuario deletado");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizaUsuario(@PathVariable Long id, @RequestBody Usuario requisicao) {
        Usuario usuario = servico.atualizaUsuario(id, requisicao);
        return ResponseEntity.ok().body(usuario);
    }
}