package com.restaurante.temperomagico.dto;

import com.restaurante.temperomagico.entity.TipoUsuario;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioUpdateDto {
    @NotNull(message = "A senha é obrigatória")
    @Size(min=8 ,message = "A senha deve possuir mais de 8 caracteres")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$")
    private String senhaAtual;

    @NotNull(message = "A senha é obrigatória")
    @Size(min=8 ,message = "A senha deve possuir mais de 8 caracteres")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$")
    private String novaSenha;

    @NotNull(message = "A senha é obrigatória")
    @Size(min=8 ,message = "A senha deve possuir mais de 8 caracteres")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$")
    private String confirmaSenha;

    @NotNull(message = "O nome é obrigatório")
    @Size(min=5 , message = "Deve ser informado o nome completo")
    private String nome;

    @NotNull(message = "O número de celular é obrigatório")
    @Size(min=9 , message = "Deve ser informado o número + DDD")
    private String celular ;


}
