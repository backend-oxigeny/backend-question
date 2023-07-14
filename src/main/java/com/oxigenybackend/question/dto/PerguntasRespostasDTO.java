package com.oxigenybackend.question.dto;
import com.oxigenybackend.question.model.Pergunta;
import com.oxigenybackend.question.model.Resposta;
import com.oxigenybackend.question.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class PerguntasRespostasDTO {
   // private Pergunta pergunta;
    private Long id;
    private String question;
    private Usuario usuario;
    private List<Resposta> respostas = new ArrayList<>();

    public PerguntasRespostasDTO() {
    }

    public PerguntasRespostasDTO(Pergunta pergunta, Long id, String question, Usuario usuario) {
        this.question = question;
        this.id = id;
        this.usuario = usuario;
    }
    public PerguntasRespostasDTO(Pergunta entity){

        this.question = entity.getQuestion();
        this.id = entity.getId();
        this.respostas = entity.getRespostas();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Resposta> getRespostasDTO() {
        return respostas;
    }

}
