package com.oxigenybackend.question.controllers;

import com.oxigenybackend.question.dto.RespostaDto;
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
    @GetMapping(value = "pergunta/{id}")
    public List<Resposta> getQuestionById(@PathVariable Long id){
        List<Resposta> respostaEntity = service.getQuestionById(id);
        return respostaEntity;
    }
    @PostMapping
    public Resposta answer(@RequestBody RespostaDto resposta){
        return service.answer(resposta);
    }
    @DeleteMapping(value = "/{id}")
    public void deleteAnswer(@PathVariable Long id){
        service.deleteAnswer(id);
    }
    @PutMapping(value = "/{id}")
    public Resposta updateAnswer(@RequestBody RespostaDto resposta, @PathVariable Long id){
      return service.updateAnswer(resposta,id);
    }
}