package com.backend.entidades;

import com.backend.entidades.enums.ClassePassagemEnum;
import com.backend.entidades.enums.StatusReservaEnum;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity(name = "tb_passagem_aerea")
public class PassagemAerea {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String assento;

    @Enumerated(EnumType.STRING)
    private StatusReservaEnum statusReserva;

    @Enumerated(EnumType.STRING)
    private ClassePassagemEnum classe;

    private Double preco;

    @ManyToOne
    @JoinColumn(name = "voo_id")
    private Voo voo;

    // private Usuario usuario;

    private LocalDateTime dataHoraReserva;

    public PassagemAerea() {
    }

    public PassagemAerea(String assento, ClassePassagemEnum classe, Double preco, LocalDateTime dataHoraReserva, StatusReservaEnum statusReserva) {
        this.assento = assento;
        this.classe = classe;
        this.preco = preco;
        this.dataHoraReserva = dataHoraReserva;
        this.statusReserva = statusReserva;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Voo getVoo() {
        return voo;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }

    public String getAssento() {
        return assento;
    }

    public void setAssento(String assento) {
        this.assento = assento;
    }

    public ClassePassagemEnum getClasse() {
        return classe;
    }

    public void setClasse(ClassePassagemEnum classe) {
        this.classe = classe;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public LocalDateTime getDataHoraReserva() {
        return dataHoraReserva;
    }

    public void setDataHoraReserva(LocalDateTime dataHoraReserva) {
        this.dataHoraReserva = dataHoraReserva;
    }

    public StatusReservaEnum getStatusReserva() {
        return statusReserva;
    }

    public void setStatusReserva(StatusReservaEnum statusReserva) {
        this.statusReserva = statusReserva;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PassagemAerea that = (PassagemAerea) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
