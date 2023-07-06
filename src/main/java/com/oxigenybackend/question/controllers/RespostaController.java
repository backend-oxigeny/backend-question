package com.oxigenybackend.question.controllers;

import com.oxigenybackend.question.model.Resposta;
import com.oxigenybackend.question.repository.RespostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping(value = "/respostas")
public class RespostaController {

    @Autowired
    private RespostaRepository repository;

    @GetMapping
    public List<Resposta> findAll(){
        return repository.findAll();
    }
}