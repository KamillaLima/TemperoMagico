package com.restaurante.temperomagico.entity;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Funcionario extends Usuario {

    @NotNull(message= "O campo deve ser informado")
    private String cargo;
}
