package com.oxigenybackend.question.repository;

import com.oxigenybackend.question.model.Pergunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerguntaRepository extends JpaRepository <Pergunta, Long> {
}
