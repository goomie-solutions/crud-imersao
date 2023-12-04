package com.backend.entidades;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity(name = "tb_voo")
public class Voo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String origem;
    private String destino;
    private LocalDateTime dataHoraPartida;
    private LocalDateTime daraHoraChegada;

    @OneToMany(mappedBy = "voo")
    private List<PassagemAerea> passagemAerea;

    public Voo() {
    }

    public Voo(String origem, String destino, LocalDateTime dataHoraPartida, LocalDateTime daraHoraChegada) {
        this.origem = origem;
        this.destino = destino;
        this.dataHoraPartida = dataHoraPartida;
        this.daraHoraChegada = daraHoraChegada;

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public List<PassagemAerea> getPassagemAerea() {
        return passagemAerea;
    }

    public void setPassagemAerea(PassagemAerea passagemAerea) {
        this.passagemAerea.add(passagemAerea);
    }

    public LocalDateTime getDataHoraPartida() {
        return dataHoraPartida;
    }

    public void setDataHoraPartida(LocalDateTime dataHoraPartida) {
        this.dataHoraPartida = dataHoraPartida;
    }

    public LocalDateTime getDaraHoraChegada() {
        return daraHoraChegada;
    }

    public void setDaraHoraChegada(LocalDateTime daraHoraChegada) {
        this.daraHoraChegada = daraHoraChegada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voo voo = (Voo) o;
        return Objects.equals(id, voo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
