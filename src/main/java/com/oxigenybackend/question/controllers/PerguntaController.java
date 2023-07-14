package com.oxigenybackend.question.controllers;

import com.oxigenybackend.question.dto.PerguntaMaxDto;
import com.oxigenybackend.question.dto.PerguntaDto;
import com.oxigenybackend.question.model.Pergunta;
import com.oxigenybackend.question.services.PerguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/perguntas")
public class PerguntaController {


    @Autowired
    private PerguntaService service;

    @GetMapping
    public List<PerguntaMaxDto> findAll(){
        return service.findAll();
    }

    @PostMapping
    public Pergunta cadastro(@RequestBody PerguntaDto pergunta){
        return service.cadastro(pergunta);
    }
    @DeleteMapping(value = "/{id}")
    public void deleteQuestion(@PathVariable Long id){
        service.delete(id);
    }
}