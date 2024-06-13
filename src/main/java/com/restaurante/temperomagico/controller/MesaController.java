package com.restaurante.temperomagico.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.temperomagico.dto.Mesa.MesaRegistrar;
import com.restaurante.temperomagico.entity.Mesa;
import com.restaurante.temperomagico.service.MesaService;


@RestController
@RequestMapping("/api/mesa")
@CrossOrigin(origins = "", allowedHeaders = "")
public class MesaController {
    
    @Autowired
    private MesaService mesaService;

    @PostMapping
    public ResponseEntity<Mesa> registrarMesa(@RequestBody MesaRegistrar mesaRegistrar){
        System.out.println("Entrou na controler: POST EM /API/MESA");
        return mesaService.RegistrarMesa(mesaRegistrar)
        .map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(resposta))
        .orElse(ResponseEntity.badRequest().build());
    }

    
}
