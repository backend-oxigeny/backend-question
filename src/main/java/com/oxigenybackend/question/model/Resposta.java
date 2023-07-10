package com.oxigenybackend.question.model;

import jakarta.persistence.*;

@Entity
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String answer;
    @ManyToOne
    @JoinColumn(name = "pergunta_id")
    private Pergunta pergunta;

    public Resposta(){

    }

    public Resposta(Long id, String answer) {
        this.id = id;
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }
}
