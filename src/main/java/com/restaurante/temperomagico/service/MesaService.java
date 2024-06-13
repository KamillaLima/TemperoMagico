package com.restaurante.temperomagico.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

        var mesaCadastrada = repository.save(MesaConverter.registrarToMesa(mesa,usuarioRelacionado.get()));
        
        System.out.println("Saiu da service com mesa cadastrada");
        return Optional.of(mesaCadastrada);
    }
    
}
