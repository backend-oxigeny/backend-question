package com.oxigenybackend.question.services;

import com.oxigenybackend.question.model.Pergunta;
import com.oxigenybackend.question.repository.PerguntaRepository;
import com.oxigenybackend.question.repository.RespostaRepository;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PerguntaService {
    @Autowired
    private PerguntaRepository repository;

    @Transactional(readOnly = true)
    public List<Pergunta> findAll(){
        return repository.findAll();
    }

    public Pergunta create(Pergunta pergunta){
        Pergunta entity = new Pergunta();
        entity.setQuestion(pergunta.getQuestion());
        repository.save(entity);
        return entity;

    }

    @Transactional
    public void delete(Long id){
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Pergunta findById(Long id){
        return repository.findById(id).get();
    }

    @Transactional
    public Pergunta update(Pergunta pergunta,Long id){
        Pergunta entity = repository.getReferenceById(id);
        entity.setQuestion(pergunta.getQuestion());
        repository.save(entity);
        return entity;
    }

    @Transactional
    public Pergunta cadastro(Pergunta pergunta){
        Pergunta entity = new Pergunta();
        entity.setQuestion(pergunta.getQuestion());
        entity.setTitle(pergunta.getTitle());
        repository.save(entity);
        return entity;
    }

}