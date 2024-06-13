package com.restaurante.temperomagico.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="tb_agendamento")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @NotNull(message = "A mesa deve ser informada")
    private Mesa mesa;

    @OneToOne
    @NotNull(message = "O usuário deve ser informado")
    private Usuario usuario;


    @NotNull(message = "A data de inicio deve ser informada")
    private LocalDateTime dataInicio;

    @NotNull(message = "A data de termino deve ser informada")
    private LocalDateTime dataTermino;

    private boolean ativo = true;


}
