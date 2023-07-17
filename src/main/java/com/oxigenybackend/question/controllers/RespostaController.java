package com.oxigenybackend.question.controllers;

import com.oxigenybackend.question.dto.DTORespostasGet;
import com.oxigenybackend.question.dto.PerguntasRespostasDTO;
import com.oxigenybackend.question.dto.RespostaDto;
import com.oxigenybackend.question.model.Resposta;
import com.oxigenybackend.question.services.RespostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/respostas")
public class RespostaController {

    @Autowired
    private RespostaService service;

    @GetMapping
    public List<DTORespostasGet> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "pergunta/{id}")
    public PerguntasRespostasDTO getQuestionById(@PathVariable Long id) {
        return service.getQuestionById(id);
    }

    @PostMapping
    public ResponseEntity<Resposta> answer(@RequestBody RespostaDto resposta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.answer(resposta));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteAnswer(@PathVariable Long id) {
        service.deleteAnswer(id);
    }

    @PutMapping(value = "/{id}")
    public Resposta updateAnswer(@RequestBody RespostaDto resposta, @PathVariable Long id) {
        return service.updateAnswer(resposta, id);
    }
}