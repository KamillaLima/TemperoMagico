package com.restaurante.temperomagico.dto.Mesa;

import com.restaurante.temperomagico.entity.Mesa;
import com.restaurante.temperomagico.entity.Usuario;

public class MesaConverter {

    public static Mesa registrarToMesa (MesaRegistrar mesaRegistrar, Usuario funcionario){
        return new Mesa(null ,mesaRegistrar.numCadeiras(), funcionario);
    }
}
