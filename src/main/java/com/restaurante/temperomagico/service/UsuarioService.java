package com.restaurante.temperomagico.service;

import com.restaurante.temperomagico.dto.UsuarioUpdateDto;
import com.restaurante.temperomagico.entity.Usuario;
import com.restaurante.temperomagico.exception.PasswordInvalidException;
import com.restaurante.temperomagico.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Transactional
    public Usuario atualizarPerfil(Long id , UsuarioUpdateDto usuarioUpdateDto){
        if(!validarSenhas(usuarioUpdateDto.getNovaSenha() , usuarioUpdateDto.getConfirmaSenha())){
            throw new PasswordInvalidException("A nova senha e confirma senha não são as mesmas");
        }
        Usuario user = procurarPorId(id);
        if(!user.getSenha().equals(usuarioUpdateDto.getSenhaAtual())){
            throw new PasswordInvalidException("A senha atual está incorreta! ");
        }
        user.setSenha(usuarioUpdateDto.getNovaSenha());
        user.setNome(usuarioUpdateDto.getNome());
        user.setCelular(usuarioUpdateDto.getCelular());
        return usuarioRepository.save(user);

    }

    @Transactional
    public boolean validarSenhas(String novaSenha , String confirmaSenha){
        return novaSenha.equals(confirmaSenha);
    }

    @Transactional
    public void deletarConta(Long id){
        Usuario usuario = procurarPorId(id);
        usuarioRepository.delete(usuario);
    }
}