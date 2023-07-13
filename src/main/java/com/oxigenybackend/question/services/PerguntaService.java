package com.oxigenybackend.question.services;

import com.oxigenybackend.question.dto.PerguntaMaxDto;
import com.oxigenybackend.question.dto.PerguntaDto;
import com.oxigenybackend.question.model.Pergunta;
import com.oxigenybackend.question.model.Usuario;
import com.oxigenybackend.question.repository.PerguntaRepository;
import com.oxigenybackend.question.repository.RespostaRepository;
import com.oxigenybackend.question.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PerguntaService {
    @Autowired
    private PerguntaRepository repository;
    @Autowired
    private RespostaRepository respostaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;



    public Pergunta create(Pergunta pergunta) {
        Pergunta entity = new Pergunta();
        entity.setQuestion(pergunta.getQuestion());
        entity.setTitle(pergunta.getTitle());
        repository.save(entity);
        return entity;

    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Pergunta findById(Long id) {
        return repository.findById(id).get();
    }

    @Transactional
    public Pergunta update(Pergunta pergunta, Long id) {
        Pergunta entity = repository.getReferenceById(id);
        entity.setQuestion(pergunta.getQuestion());
        entity.setTitle(pergunta.getTitle());
        repository.save(entity);
        return entity;
    }

    @Transactional
    public Pergunta cadastro(PerguntaDto dto) {
        Pergunta entity = new Pergunta();
        entity.setQuestion(dto.getQuestion());
        entity.setTitle(dto.getTitle());

        Usuario user = usuarioRepository.getReferenceById(dto.getUsuario());
        entity.setUsuario(user);
        repository.save(entity);
        return entity;
    }

    @Transactional(readOnly = true)
    public List<PerguntaMaxDto> findAll(){
       List<Pergunta> resultado = repository.findAll();
       List<PerguntaMaxDto> perguntaMaxDtos= new ArrayList<>();
       for(Pergunta p : resultado){
            perguntaMaxDtos.add(new PerguntaMaxDto(p));
        }

       return perguntaMaxDtos;
  }
}