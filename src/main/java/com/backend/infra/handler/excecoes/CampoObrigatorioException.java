package com.backend.infra.handler.excecoes;

public class CampoObrigatorioException extends RuntimeException{

    public CampoObrigatorioException(Object campo) {
        super(campo.toString());
    }
}
