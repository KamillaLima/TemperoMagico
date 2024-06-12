package com.restaurante.temperomagico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.temperomagico.dto.RetornoMesaRegistro;
import com.restaurante.temperomagico.entity.Mesa;
import com.restaurante.temperomagico.service.MesaService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/mesa")
@CrossOrigin("*")
public class MesaController {
    
    @Autowired
    private MesaService mesaService;

    @PostMapping
    public ResponseEntity<RetornoMesaRegistro> registrar(@Valid @RequestBody Mesa mesa){
        var mesaCadastrada = mesaService.registrar(mesa);
        if (mesaCadastrada == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        var dtoMesa = new RetornoMesaRegistro(mesaCadastrada.get().getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(dtoMesa);
    }

}
