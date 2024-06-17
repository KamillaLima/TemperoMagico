package com.restaurante.temperomagico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.temperomagico.Exceptions.UsuarioOuMesaNaoExistem;
import com.restaurante.temperomagico.dto.Agendamento.CriarAgendamento;
import com.restaurante.temperomagico.entity.Agendamento;
import com.restaurante.temperomagico.service.AgendamentoService;

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
}
