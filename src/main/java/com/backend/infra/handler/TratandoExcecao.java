package com.backend.infra.handler;

import com.backend.infra.handler.excecoes.CampoObrigatorioException;
import com.backend.infra.handler.excecoes.RegistroNaoLocalizadoException;
import com.backend.infra.handler.excecoes.UsuarioNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class TratandoExcecao {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErroPadrao> argumentoIlegal(IllegalArgumentException e) {
        String erro = "Argumento ilegal. Cheque os parâmetros";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErroPadrao resposta = new ErroPadrao(LocalDateTime.now(), status.value(), erro, e.getMessage());
        return ResponseEntity.status(status).body(resposta);
    }

    @ExceptionHandler(UsuarioNaoEncontradoException.class)
    public ResponseEntity<ErroPadrao> usuarioNaoEncontrado(UsuarioNaoEncontradoException e) {
        String erro = "O usuário não foi encontrado.";
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErroPadrao resposta = new ErroPadrao(LocalDateTime.now(), status.value(), erro, e.getMessage());
        return ResponseEntity.status(status).body(resposta);
    }

    @ExceptionHandler(CampoObrigatorioException.class)
    public ResponseEntity<ErroPadrao> campoObrigatorio(CampoObrigatorioException e) {
        String erro = String.format("Campo obrigatório");
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErroPadrao resposta = new ErroPadrao(LocalDateTime.now(), status.value(), erro, e.getMessage());
        return ResponseEntity.status(status).body(resposta);
    }

    @ExceptionHandler(RegistroNaoLocalizadoException.class)
    public ResponseEntity<ErroPadrao> registroNaoLocalizado(RegistroNaoLocalizadoException e) {
        String erro = "Registro não encontrado";
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErroPadrao resposta = new ErroPadrao(LocalDateTime.now(), status.value(), erro, e.getMessage());
        return ResponseEntity.status(status).body(resposta);
    }
}
