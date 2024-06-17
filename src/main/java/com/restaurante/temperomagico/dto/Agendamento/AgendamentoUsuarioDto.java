package com.restaurante.temperomagico.dto.Agendamento;

import java.time.LocalDateTime;

public record AgendamentoUsuarioDto(String nomeFuncionario, LocalDateTime dataInicio, LocalDateTime dataFim, boolean ativo) {
    
}
