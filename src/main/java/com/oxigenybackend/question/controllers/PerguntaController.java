package com.oxigenybackend.question.controllers;

import com.oxigenybackend.question.dto.PerguntaDto;
import com.oxigenybackend.question.model.Pergunta;
import com.oxigenybackend.question.repository.PerguntaRepository;
import com.oxigenybackend.question.services.PerguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/perguntas")
public class PerguntaController {

    @Autowired
    private PerguntaRepository repository;

    @Autowired
    private PerguntaService service;

    @GetMapping
    public List<Pergunta> findAll(){
        return repository.findAll();
    }

    @PostMapping
    public Pergunta cadastro(@RequestBody PerguntaDto pergunta){
        return service.cadastro(pergunta);

    }

}