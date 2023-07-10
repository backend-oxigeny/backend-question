package com.oxigenybackend.question.controllers;

import com.oxigenybackend.question.model.Pergunta;
import com.oxigenybackend.question.model.Resposta;
import com.oxigenybackend.question.repository.RespostaRepository;
import com.oxigenybackend.question.services.RespostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/respostas")
public class RespostaController {

    @Autowired
    private RespostaService service;

    @GetMapping
    public List<Resposta> findAll(){
        return service.findAll();
    }
    @GetMapping(value = "/{id}")
    public List<Resposta> getQuestionById(@PathVariable Long id){
        List<Resposta> respostaEntity = service.getQuestionById(id);
        return respostaEntity;
    }
    @PostMapping
    public Resposta answer(@RequestBody Resposta resposta){
        return service.answer(resposta);
    }
}