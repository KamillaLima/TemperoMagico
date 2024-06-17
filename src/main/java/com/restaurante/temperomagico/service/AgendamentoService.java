package com.restaurante.temperomagico.service;

import java.util.Optional;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException.NotImplemented;

import com.restaurante.temperomagico.Exceptions.UsuarioOuMesaNaoExistem;
import com.restaurante.temperomagico.dto.Agendamento.AgendamentoConverter;
import com.restaurante.temperomagico.dto.Agendamento.CriarAgendamento;
import com.restaurante.temperomagico.entity.Agendamento;
import com.restaurante.temperomagico.entity.Mesa;
import com.restaurante.temperomagico.entity.Usuario;
import com.restaurante.temperomagico.repository.AgendamentoRepository;
import com.restaurante.temperomagico.repository.MesaRepository;
import com.restaurante.temperomagico.repository.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AgendamentoService {
    
    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MesaRepository mesaRepository;

    public Agendamento registrarAgendamento(CriarAgendamento agendamentoDto){
        var mesa = mesaRepository.findById(agendamentoDto.idTipoMesa());
        var usuario = usuarioRepository.findById(agendamentoDto.idUsuario());

        if (mesa == null || usuario == null){
            throw new UsuarioOuMesaNaoExistem("Não foi possível encontrar usuário ou mesa com os IDs fornecidos");
        }

        var agendamentoRegistrado = AgendamentoConverter.criarAgendamentoToAgendamento(agendamentoDto,mesa.get(),usuario.get());

        agendamentoRepository.save(agendamentoRegistrado);
        return agendamentoRegistrado;

    }

    public Agendamento pegarAgendamentoPeloId (Long id){
        return agendamentoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Não foi possível encontrar nenhum agendamento com esse ID"));
    }
}
