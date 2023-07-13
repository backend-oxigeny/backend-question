package com.oxigenybackend.question.dto;

import com.oxigenybackend.question.model.Pergunta;

public class PerguntaMaxDto {
    private  Integer QuantidadeDeResposta;
    private Long id;

    private String question;
    private String title;

    private String usuario;

    public PerguntaMaxDto() {
    }

    public PerguntaMaxDto(Integer quantedadeDeResposta, Long id, String question, String title, String usuario) {
        QuantidadeDeResposta = quantedadeDeResposta;
        this.id = id;
        this.question = question;
        this.title = title;
        this.usuario = usuario;
    }
    public PerguntaMaxDto(Pergunta entity) {
        QuantidadeDeResposta = entity.getRespostas().size();
        this.id = entity.getId();
        this.question = entity.getQuestion();
        this.title = entity.getTitle();
        this.usuario = entity.getUsuario().getNome();
    }

    public Integer getQuantedadeDeResposta() {
        return QuantidadeDeResposta;
    }

    public void setQuantedadeDeResposta(Integer quantedadeDeResposta) {
        QuantidadeDeResposta = quantedadeDeResposta;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
