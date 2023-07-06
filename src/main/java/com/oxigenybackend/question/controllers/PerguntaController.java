package com.oxigenybackend.question.controllers;

import com.oxigenybackend.question.model.Pergunta;
import com.oxigenybackend.question.repository.PerguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/perguntas")
public class PerguntaController {

    @Autowired
    private PerguntaRepository repository;

    @GetMapping
    public List<Pergunta> findAll(){
        return repository.findAll();
    }
}