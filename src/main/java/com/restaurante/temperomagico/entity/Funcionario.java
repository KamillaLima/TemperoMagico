package com.restaurante.temperomagico.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Funcionario extends Usuario {

    @NotNull(message= "O campo deve ser informado")
    private String cargo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "funcionario", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("funcionario")
    private List<Mesa> mesa;
}
