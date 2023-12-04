package com.backend.servicos;

import com.backend.entidades.Usuario;
import com.backend.infra.handler.excecoes.CampoObrigatorioException;
import com.backend.infra.handler.excecoes.UsuarioNaoEncontradoException;
import com.backend.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServico {

    @Autowired
    private UsuarioRepositorio repositorio;

    public Usuario consultaUsuario(Long id) {
        Usuario usuario = repositorio.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException("Usuario nao encontrado"));

        return usuario;
    }

    public Usuario criaUsuario(Usuario user) {
        List<String> campo = checaCampos(user);

        if(!campo.isEmpty()) {
            String mensagem = "O(s) seguinte(s) campo(s) é(são) obrigatório(s):" +
                    String.join(", ", campo);
            throw new CampoObrigatorioException(mensagem);
        }

        Usuario usuario = repositorio.save(user);
        return usuario;
    }

    public void deletaUsuario(Long id) {
        Usuario usuario = repositorio.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(
                        String.format("Usuário de id %01d não foi encontrado", id)));
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

    private List checaCampos(Usuario usuario) {
        List<String> resultado = new ArrayList<>();

        if(usuario.getNome() == null) resultado.add("nome");
        if(usuario.getEmail() == null) resultado.add("e-mail");
        if(usuario.getSenha() == null) resultado.add("senha");

        return resultado;
    }
}