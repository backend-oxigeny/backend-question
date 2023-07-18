package com.oxigenybackend.question.controllers;

import com.oxigenybackend.question.dto.PerguntaMaxDto;
import com.oxigenybackend.question.dto.PerguntaDto;
import com.oxigenybackend.question.model.Pergunta;
import com.oxigenybackend.question.services.PerguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<Pergunta>  cadastro(@RequestBody PerguntaDto pergunta){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(pergunta.getId()).toUri();
        return ResponseEntity.created(uri).body(service.cadastro(pergunta));
    }
    @PutMapping(value = "/{id}")
    public Pergunta update(@RequestBody Pergunta pergunta, @PathVariable Long id){
      return service.update(pergunta, id);
    }
    @DeleteMapping(value = "/{id}")
    public void deleteQuestion(@PathVariable Long id){
        service.delete(id);
    }
}