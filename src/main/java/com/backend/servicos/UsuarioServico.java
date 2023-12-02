package com.backend.servicos;

import com.backend.entidades.Usuario;
import com.backend.repositorios.UsuarioRepositorio;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServico {

    @Autowired
    private UsuarioRepositorio repositorio;

    public Usuario consultaUsuario(Long id) {
        Usuario usuario = repositorio.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario nao encontrado"));

        return usuario;
    }

    public Usuario criaUsuario(Usuario user) {
        Usuario usuario = repositorio.save(user);
        return usuario;
    }

    public void deletaUsuario(Long id) {
        repositorio.deleteById(id);
    }

    public Usuario atualizaUsuario(Long id, Usuario requisicao) {
        Usuario usuario = consultaUsuario(id);

        atualizaTodosOsCampos(usuario, requisicao);
        Usuario usuarioAtualizado = repositorio.save(usuario);
        return usuarioAtualizado;
    }

    private void atualizaTodosOsCampos(Usuario usuarioQueVemDoBancoDeDados, Usuario requisicao) {
        usuarioQueVemDoBancoDeDados.setNome(requisicao.getNome());
        usuarioQueVemDoBancoDeDados.setEmail(requisicao.getEmail());
        usuarioQueVemDoBancoDeDados.setSenha(requisicao.getSenha());
    }
}