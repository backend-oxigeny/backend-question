package com.oxigenybackend.question.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Pergunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String question;

    @OneToMany(mappedBy = "pergunta")
    private List <Resposta> respostas = new ArrayList<>();


    public Pergunta(){

    }
    public Pergunta(Long id, String question, String title) {
        this.title = title;
        this.id = id;
        this.question = question;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public List<Resposta> getRespostas() {
        return respostas;
    }
}
