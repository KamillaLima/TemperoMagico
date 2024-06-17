package com.restaurante.temperomagico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.temperomagico.Exceptions.UsuarioOuMesaNaoExistem;
import com.restaurante.temperomagico.dto.Agendamento.AgendamentoConverter;
import com.restaurante.temperomagico.dto.Agendamento.AgendamentoUsuarioDto;
import com.restaurante.temperomagico.dto.Agendamento.CriarAgendamento;
import com.restaurante.temperomagico.entity.Agendamento;
import com.restaurante.temperomagico.service.AgendamentoService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/agendamento")
@CrossOrigin(origins = "", allowedHeaders = "")
public class AgendamentoController {
    
    @Autowired
    AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<Agendamento> registrarAgendamento (CriarAgendamento agendamentoDto){
        try{
            var agendamentoRegistrado = agendamentoService.registrarAgendamento(agendamentoDto);
            return ResponseEntity.ok().body(agendamentoRegistrado);
            
        }catch(UsuarioOuMesaNaoExistem excp){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoUsuarioDto> pegarAgendamentoPeloId(@PathVariable Long id){
        try {
            var agendamento = agendamentoService.pegarAgendamentoPeloId(id);
            var agendamentoDto = AgendamentoConverter.agendamentoToAgendamentoUsuarioDto(agendamento);
            return ResponseEntity.ok().body(agendamentoDto);
        }catch(EntityNotFoundException excp){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AgendamentoUsuarioDto> desativarAgendamento(Long id){
        try {
            agendamentoService.desativarAgendamento(id);
            return ResponseEntity.noContent().build();
        }catch(EntityNotFoundException excp){
            return ResponseEntity.notFound().build();
        }
    }
}
