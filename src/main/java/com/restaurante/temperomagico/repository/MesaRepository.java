package com.restaurante.temperomagico.repository;

import com.restaurante.temperomagico.entity.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MesaRepository extends JpaRepository<Mesa,Long> {
    boolean existsById(Long id);
}
