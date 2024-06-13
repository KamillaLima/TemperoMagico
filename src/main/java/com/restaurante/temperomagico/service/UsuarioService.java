package com.restaurante.temperomagico.service;

import com.restaurante.temperomagico.entity.Usuario;
import com.restaurante.temperomagico.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario salvar(Usuario usuario) {
            return usuarioRepository.save(usuario);
    }



    @Transactional(readOnly = true)
    public Usuario procurarPorId(Long id) {
        Optional<Usuario> usuarioOptional =  usuarioRepository.findById(id);
        return usuarioOptional.orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com o ID: " + id));
    }

}