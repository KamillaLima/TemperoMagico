package com.restaurante.temperomagico.repository;

import com.restaurante.temperomagico.entity.Agendamento;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface AgendamentoRepository extends JpaRepository<Agendamento,Long> {
    boolean existsById(Long id);

    @Query(value = "SELECT a.id, a.ativo, a.data_inicio, a.data_termino, a.mesa_id, a.usuario_id FROM tb_agendamento a WHERE data_inicio BETWEEN :dataInicial AND :dataFinal", nativeQuery = true)
    List<Agendamento> buscarPorIntervaloDeDatas(LocalDateTime dataInicial, LocalDateTime dataFinal);

}
