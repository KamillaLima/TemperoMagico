package com.restaurante.temperomagico.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_usuario")
public abstract class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O nome é obrigatório")
    @Size(min=5 , message = "Deve ser informado o nome completo")
    private String nome;

    @Email
    @NotNull(message = "O email é obrigatório")
    private String email;

    @NotNull(message = "A senha é obrigatória")
    @Size(min=8 ,message = "A senha deve possuir mais de 8 caracteres")
    private String senha;

}
