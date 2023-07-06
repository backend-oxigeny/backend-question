package com.oxigenybackend.question.repository;

import com.oxigenybackend.question.model.Pergunta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerguntaRepository extends JpaRepository <Pergunta, Long> {
}
