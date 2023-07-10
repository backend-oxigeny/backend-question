package com.oxigenybackend.question.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Pergunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @Column(columnDefinition = "TEXT")
    private String question;

    @JsonIgnore
    @Column(columnDefinition = "TEXT")
    private Object hibernateLazyInitializer;



    @OneToMany(mappedBy = "pergunta")
    private List <Resposta> respostas = new ArrayList<>();


    public Pergunta(){

    }
    public Pergunta(Long id, String question) {

        this.id = id;
        this.question = question;
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

    @JsonIgnore
    public List<Resposta> getRespostas() {
        return respostas;
    }
}
