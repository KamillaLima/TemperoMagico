package com.restaurante.temperomagico.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.temperomagico.Exceptions.MesaJaExiste;
import com.restaurante.temperomagico.dto.Mesa.MesaConverter;
import com.restaurante.temperomagico.dto.Mesa.MesaRegistrar;
import com.restaurante.temperomagico.entity.Mesa;
import com.restaurante.temperomagico.repository.MesaRepository;
import com.restaurante.temperomagico.repository.UsuarioRepository;

@Service
public class MesaService {
    
    @Autowired
    private MesaRepository repository;

    @Autowired
    private UsuarioRepository userRepository;

    public Optional<Mesa> RegistrarMesa(MesaRegistrar mesa){
        System.out.println("Entrou na service: Registrar mesa");
        var usuarioRelacionado = userRepository.findById(mesa.idFuncionario());
        if (usuarioRelacionado.isEmpty()) return null;

        if (repository.existsById(mesa.id())){
            throw new MesaJaExiste("O ID informado para essa mesa já esta cadastrado");
        }

        
        var mesaCadastrada = MesaConverter.registrarToMesa(mesa,usuarioRelacionado.get());
        repository.save(mesaCadastrada);
        System.out.println("Saiu da service com mesa cadastrada");
        return Optional.of(mesaCadastrada);
    }
    
    public Optional<Mesa> PegarPeloId(Long id) {
        var mesaDb = repository.findById(id);
        if (mesaDb.isEmpty()) return null;
        return mesaDb;
    }

    
}
