package com.restaurante.temperomagico.dto.Agendamento;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.restaurante.temperomagico.entity.Agendamento;
import com.restaurante.temperomagico.entity.Mesa;
import com.restaurante.temperomagico.entity.Usuario;

public class AgendamentoConverter {

    public static Agendamento criarAgendamentoToAgendamento (CriarAgendamento agendamentoDto, Mesa mesa, Usuario usuario){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        var dataInicio = LocalDateTime.parse(agendamentoDto.dataInicio(), formatter);

        return new Agendamento(null, mesa, usuario, dataInicio, dataInicio.plusHours(2l), true);
    }

}


