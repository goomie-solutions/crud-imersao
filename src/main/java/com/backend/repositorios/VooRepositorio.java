package com.backend.repositorios;

import com.backend.entidades.Voo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VooRepositorio extends JpaRepository<Voo, UUID> {
}
