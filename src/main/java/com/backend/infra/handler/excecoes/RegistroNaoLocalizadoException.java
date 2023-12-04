package com.backend.infra.handler.excecoes;

public class RegistroNaoLocalizadoException extends RuntimeException {

    public RegistroNaoLocalizadoException(String mensagem) {
        super(mensagem);
    }

}
