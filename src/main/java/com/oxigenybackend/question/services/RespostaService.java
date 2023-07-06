package com.oxigenybackend.question.services;

import com.oxigenybackend.question.model.Resposta;
import com.oxigenybackend.question.repository.RespostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RespostaService {
    @Autowired
    private RespostaRepository repository;

    public List<Resposta> findAll(){
        return repository.findAll();
    }

    public Resposta create(Resposta resposta){
        Resposta entity = new Resposta();
        entity.setAnswer(resposta.getAnswer());
        repository.save(entity);
        return entity;

    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Resposta findById(Long id){
        return repository.findById(id).get();
    }


    public Resposta update(Resposta resposta,Long id){
        Resposta entity = repository.getReferenceById(id);
        entity.setAnswer(resposta.getAnswer());
        repository.save(entity);
        return entity;
    }
}
