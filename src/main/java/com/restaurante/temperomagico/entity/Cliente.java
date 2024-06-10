package com.restaurante.temperomagico.entity;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends Usuario{


    private String foto;

    @NotNull(message = "O número de celular é obrigatório")
    @Size(min=9 , message = "Deve ser informado o número + DDD")
    private String celular;
}
