package com.restaurante.temperomagico.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.temperomagico.Exceptions.MesaJaExiste;
import com.restaurante.temperomagico.dto.Mesa.MesaRegistrar;
import com.restaurante.temperomagico.entity.Mesa;
import com.restaurante.temperomagico.service.MesaService;

import jakarta.websocket.server.PathParam;


@RestController
@RequestMapping("/api/mesa")
@CrossOrigin(origins = "", allowedHeaders = "")
public class MesaController {
    
    @Autowired
    private MesaService mesaService;

    @PostMapping
    public ResponseEntity<Mesa> registrarMesa(@RequestBody MesaRegistrar mesaRegistrar){
        System.out.println("Entrou na controler: POST EM /API/MESA");
        try{
            var mesaRegistrada = mesaService.RegistrarMesa(mesaRegistrar);
            return mesaRegistrada.map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(resposta))
            .orElse(ResponseEntity.badRequest().build());

        }catch(MesaJaExiste idJaExiste){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mesa> pegarMesaPeloId (@PathVariable Long id){
        var respService = mesaService.PegarPeloId(id);
        if (respService == null) return ResponseEntity.notFound().build();

        return respService.map(response -> ResponseEntity.status(HttpStatus.OK).body(response))
        .orElse(ResponseEntity.badRequest().build());
    }
    
    

}
