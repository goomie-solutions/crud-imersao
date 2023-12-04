package com.backend.servicos;


import com.backend.entidades.Voo;
import com.backend.infra.handler.excecoes.CampoObrigatorioException;
import com.backend.infra.handler.excecoes.RegistroNaoLocalizadoException;
import com.backend.repositorios.VooRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class VooServico {

    @Autowired
    private VooRepositorio repositorio;

    public Voo consultaVoo(UUID id) {
        Voo voo = repositorio.findById(id)
                .orElseThrow(() -> new RegistroNaoLocalizadoException("O voo de uuid " + id + " não foi encontrado"));
        return voo;
    }

    public Voo registraVoo(Voo requisicao) {

        List<String> campo = checaCampos(requisicao);

        if(!campo.isEmpty()) {
            String mensagem = "O(s) seguinte(s) campo(s) é(são) obrigatório(s):" +
                    String.join(", ", campo);
            throw new CampoObrigatorioException(mensagem);
        }

        Voo vooObj = repositorio.save(requisicao);
        return vooObj;
    }

    public void deletaVoo(UUID id) {
        repositorio.findById(id).orElseThrow(() -> new RegistroNaoLocalizadoException(String.format("O voo de id %s não foi encontrado", id)));
        repositorio.deleteById(id);
    }


    private List<String> checaCampos(Voo voo) {
        List<String> resultado = new ArrayList<>();

        if(voo.getDestino() == null) resultado.add("destino");
        if(voo.getOrigem() == null) resultado.add("origem");
        if(voo.getdataHoraChegada() == null) resultado.add("Data de chegada");
        if(voo.getDataHoraPartida() == null) resultado.add("Data de partida");

        return resultado;
    }
}
