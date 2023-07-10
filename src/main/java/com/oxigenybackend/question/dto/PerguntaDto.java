package com.oxigenybackend.question.dto;

import com.oxigenybackend.question.model.Pergunta;

public class PerguntaDto {
    private Long id;

    private String question;

    private Long usuario;

    public PerguntaDto(){

    }

    public PerguntaDto(Long id, String question, Long usuario) {
        this.id = id;
        this.question = question;
        this.usuario = usuario;
    }

    public PerguntaDto(Pergunta entity) {
        this.id = entity.getId();
        this.question = entity.getQuestion();
        this.usuario = entity.getUsuario().getId();
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

    public Long getUsuario() {
        return usuario;
    }

    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }
}
