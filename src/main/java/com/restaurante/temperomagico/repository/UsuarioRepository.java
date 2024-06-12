package com.restaurante.temperomagico.repository;

import com.restaurante.temperomagico.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
