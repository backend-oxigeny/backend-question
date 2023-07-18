package com.oxigenybackend.question.dto;
import com.oxigenybackend.question.model.Pergunta;

import java.util.ArrayList;
import java.util.List;

public class PerguntasRespostasDTOGet {
   // private Pergunta pergunta;
    private Long id;
    private String title;
    private String question;
    private UsuarioRespostaDto usuario;

    public PerguntasRespostasDTOGet() {
    }

    public PerguntasRespostasDTOGet(String title, Long id, String question, UsuarioRespostaDto usuario) {
        this.title = title;
        this.question = question;
        this.id = id;
        this.usuario = usuario;
    }
    public PerguntasRespostasDTOGet(Pergunta entity){
        this.question = entity.getQuestion();
        this.id = entity.getId();
        this.title = entity.getTitle();
        UsuarioRespostaDto usuario = new UsuarioRespostaDto();
        usuario.setNome(getUsuario().getNome());
        usuario.setId(getUsuario().getId());
        this.usuario = usuario;
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

    public UsuarioRespostaDto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioRespostaDto usuario) {
        this.usuario = usuario;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
