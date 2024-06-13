package com.restaurante.temperomagico.repository;

import com.restaurante.temperomagico.dto.UsuarioResponseDto;
import com.restaurante.temperomagico.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {


    boolean existsTb_usuarioByEmail(@Param("email") String email);
}
