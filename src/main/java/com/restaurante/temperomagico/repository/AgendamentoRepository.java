package com.restaurante.temperomagico.repository;

import com.restaurante.temperomagico.entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento,Long> {
    boolean existsById(Long id);
}
