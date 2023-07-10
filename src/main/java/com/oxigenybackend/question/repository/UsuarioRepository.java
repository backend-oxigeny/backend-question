package com.oxigenybackend.question.repository;

import com.oxigenybackend.question.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
