package com.backend.repositorios;

import com.backend.entidades.PassagemAerea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PassagemAereaRepositorio extends JpaRepository<PassagemAerea, UUID> {
}
