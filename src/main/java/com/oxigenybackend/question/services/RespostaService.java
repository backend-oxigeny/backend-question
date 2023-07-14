package com.oxigenybackend.question.services;

import com.oxigenybackend.question.dto.*;
import com.oxigenybackend.question.model.Pergunta;
import com.oxigenybackend.question.model.Resposta;
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
public class RespostaService {
    @Autowired
    private RespostaRepository respostaRepository;
    @Autowired
    private PerguntaRepository perguntaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;


    @Transactional(readOnly = true)
    public List<Resposta> findAll() {
        return respostaRepository.findAll();
    }


    public Resposta create(Resposta resposta) {
        Resposta entity = new Resposta();
        entity.setAnswer(resposta.getAnswer());
        respostaRepository.save(entity);
        return entity;

    }

    @Transactional
    public void delete(Long id) {
        respostaRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Resposta findById(Long id) {
        return respostaRepository.findById(id).get();
    }


    @Transactional
    public Resposta update(Resposta resposta, Long id) {
        Resposta entity = respostaRepository.getReferenceById(id);
        entity.setAnswer(resposta.getAnswer());
        respostaRepository.save(entity);
        return entity;
    }

    public PerguntasRespostasDTO getQuestionById(Long id) {
        Pergunta pergunta = perguntaRepository.getReferenceById(id);
        PerguntasRespostasDTO perguntasRespostasDTO = new PerguntasRespostasDTO();
        perguntasRespostasDTO.setId(pergunta.getId());
        perguntasRespostasDTO.setQuestion(pergunta.getQuestion());
        UsuarioRespostaDto user = new UsuarioRespostaDto();
        user.setId(pergunta.getUsuario().getId());
        user.setNome(pergunta.getUsuario().getNome());
        perguntasRespostasDTO.setUsuario(user);


        pergunta.getRespostas().forEach(f -> perguntasRespostasDTO.getRespostasDTO().add(new RespostaDTOOut(f)));
        return perguntasRespostasDTO;
    }

    public Resposta answer(RespostaDto dto) {
        Resposta entity = new Resposta();
        entity.setAnswer(dto.getAnswer());
        entity.setPergunta(perguntaRepository.getReferenceById(dto.getPergunta()));

        Usuario user = usuarioRepository.getReferenceById(dto.getUsuario());

        entity.setUsuario(user);

        return respostaRepository.save(entity);
    }

    public void deleteAnswer(Long id){
        respostaRepository.deleteById(id);
    }
    public Resposta updateAnswer(RespostaDto dto, Long id){
        Resposta entity = respostaRepository.getReferenceById(id);
        entity.setAnswer(dto.getAnswer());
        return respostaRepository.save(entity);
    }
}
