package com.backend.entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataHoraPartida;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataHoraChegada;

    @OneToMany(mappedBy = "voo")
    private List<PassagemAerea> passagemAerea;

    public Voo() {
    }

    public Voo(String origem, String destino, LocalDateTime dataHoraPartida, LocalDateTime dataHoraChegada) {
        this.origem = origem;
        this.destino = destino;
        this.dataHoraPartida = dataHoraPartida;
        this.dataHoraChegada = dataHoraChegada;

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

    @JsonIgnore
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

    public LocalDateTime getdataHoraChegada() {
        return dataHoraChegada;
    }

    public void setdataHoraChegada(LocalDateTime dataHoraChegada) {
        this.dataHoraChegada = dataHoraChegada;
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
