package com.restaurante.temperomagico.service;
import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.temperomagico.entity.Mesa;
import com.restaurante.temperomagico.repository.MesaRepository;

@Service
public class MesaService {
    
    @Autowired
    private MesaRepository repository;

    public Optional<Mesa> registrar(Mesa mesa){
        
        var registrado = repository.save(mesa);

        return Optional.of(registrado);
    } 

}
