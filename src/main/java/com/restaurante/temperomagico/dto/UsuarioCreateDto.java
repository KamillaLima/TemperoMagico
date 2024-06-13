package com.restaurante.temperomagico.dto;

import com.restaurante.temperomagico.entity.TipoUsuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UsuarioCreateDto {


    @NotNull(message = "O nome é obrigatório")
    @Size(min=5 , message = "Deve ser informado o nome completo")
    private String nome;

    @Email
    @Column(unique=true)
    @NotNull(message = "O email é obrigatório")
    private String email;

    @NotNull(message = "A senha é obrigatória")
    @Size(min=8 ,message = "A senha deve possuir mais de 8 caracteres")
    private String senha;

    @NotNull(message = "O número de celular é obrigatório")
    @Size(min=9 , message = "Deve ser informado o número + DDD")
    private String celular ;

    private String foto;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario ;

}
