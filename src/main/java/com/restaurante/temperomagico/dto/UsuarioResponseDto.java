package com.restaurante.temperomagico.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UsuarioResponseDto {

    private Long id;

    private String nome;

    private String email;

    private String foto;
}
