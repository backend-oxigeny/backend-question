package com.oxigenybackend.question.services;

import com.oxigenybackend.question.dto.RespostaDto;
import com.oxigenybackend.question.model.Pergunta;
import com.oxigenybackend.question.model.Resposta;
import com.oxigenybackend.question.repository.PerguntaRepository;
import com.oxigenybackend.question.repository.RespostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class RespostaService {
    @Autowired
    private RespostaRepository respostaRepository;
    @Autowired
    private PerguntaRepository perguntaRepository;

    @Transactional(readOnly = true)
    public List<Resposta> findAll(){
        return respostaRepository.findAll();
    }


    public Resposta create(Resposta resposta){
        Resposta entity = new Resposta();
        entity.setAnswer(resposta.getAnswer());
        respostaRepository.save(entity);
        return entity;

    }

    @Transactional
    public void delete(Long id){
        respostaRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Resposta findById(Long id){
        return respostaRepository.findById(id).get();
    }


    @Transactional
    public Resposta update(Resposta resposta,Long id){
        Resposta entity = respostaRepository.getReferenceById(id);
        entity.setAnswer(resposta.getAnswer());
        respostaRepository.save(entity);
        return entity;
    }
    public List<Resposta> getQuestionById(Long id){
        Pergunta entity = perguntaRepository.getReferenceById(id);
        entity.getRespostas().stream().forEach(System.out::println);
        return entity.getRespostas();
    }
    public Resposta answer(RespostaDto dto){
        Resposta entity = new Resposta();
        entity.setAnswer(dto.getAnswer());
        entity.setPergunta(perguntaRepository.getReferenceById(dto.getPergunta()));
       return respostaRepository.save(entity);
    }
}
