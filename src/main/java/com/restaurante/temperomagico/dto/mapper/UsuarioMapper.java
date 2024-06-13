package com.restaurante.temperomagico.dto.mapper;

import com.restaurante.temperomagico.dto.UsuarioCreateDto;
import com.restaurante.temperomagico.dto.UsuarioResponseDto;
import com.restaurante.temperomagico.entity.Usuario;

import org.modelmapper.ModelMapper;

public class UsuarioMapper {
    public static Usuario toUsuario(UsuarioCreateDto usuarioCreateDto ){
        return new ModelMapper().map(usuarioCreateDto, Usuario.class);
    }

    /*
     * Qual a função desse método ? Quando realizamos operações no banco,devido a
     * interface do UsuarioRepository os objetos vem modelados na classe
     * Usuario,nela trazem inumeros atributos e entre eles senha,por exemplo. Não
     * seria uma boa prática retornar uma senha,desse modo o método toDto esta
     * mapeando para que no momento de retorno o objeto sera transformado de Usuario
     * para UsuarioResponseDto,no qual possui menos atributos para serem
     * retornados.
     */

    public static UsuarioResponseDto toDto(Usuario usuario){

        UsuarioResponseDto usuarioResponseDto = new UsuarioResponseDto();
        usuarioResponseDto.setEmail(usuario.getEmail());
        usuarioResponseDto.setId(usuario.getId());
        usuarioResponseDto.setNome(usuario.getNome());
        usuarioResponseDto.setFoto(usuario.getFoto());
        return usuarioResponseDto;

    }

}
