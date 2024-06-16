package com.restaurante.temperomagico.controller;


import com.restaurante.temperomagico.dto.UsuarioCreateDto;
import com.restaurante.temperomagico.dto.UsuarioResponseDto;
import com.restaurante.temperomagico.dto.UsuarioUpdateDto;
import com.restaurante.temperomagico.dto.mapper.UsuarioMapper;
import com.restaurante.temperomagico.entity.Usuario;
import com.restaurante.temperomagico.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {


    @Autowired
    private UsuarioService usuarioService;


    @PostMapping
    public ResponseEntity<UsuarioResponseDto> registrar(@Valid @RequestBody UsuarioCreateDto usuarioCreateDto){
        Usuario user = usuarioService.salvar(UsuarioMapper.toUsuario(usuarioCreateDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toDto(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> findById(@PathVariable Long id){
        Usuario user = usuarioService.procurarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(UsuarioMapper.toDto(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> atualizar(@PathVariable Long id ,
                                                        @Valid @RequestBody UsuarioUpdateDto usuarioUpdateDto ){
        Usuario usuario = usuarioService.atualizarPerfil(id , usuarioUpdateDto);

        return ResponseEntity.status(HttpStatus.OK).body(UsuarioMapper.toDto(usuario));
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id){
        usuarioService.deletarConta(id);
    }
}
