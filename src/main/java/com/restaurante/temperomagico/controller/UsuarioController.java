package com.restaurante.temperomagico.controller;


import com.restaurante.temperomagico.dto.UsuarioCreateDto;
import com.restaurante.temperomagico.dto.UsuarioResponseDto;
import com.restaurante.temperomagico.dto.mapper.UsuarioMapper;
import com.restaurante.temperomagico.entity.Usuario;
import com.restaurante.temperomagico.repository.UsuarioRepository;
import com.restaurante.temperomagico.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {


    @Autowired
    private UsuarioService usuarioService;


    @PostMapping
    public ResponseEntity<UsuarioResponseDto> registrar(@Valid @RequestBody UsuarioCreateDto usuarioDto){
        Usuario user = usuarioService.salvar(UsuarioMapper.toUsuario(usuarioDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toDto(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> findById(@PathVariable Long id){
        Usuario user = usuarioService.procurarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(UsuarioMapper.toDto(user));
    }



}
