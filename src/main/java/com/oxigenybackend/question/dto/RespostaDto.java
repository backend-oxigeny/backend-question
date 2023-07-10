package com.oxigenybackend.question.dto;

import com.oxigenybackend.question.model.Resposta;

public class RespostaDto {
    private String answer;

    private Long  pergunta;

    public RespostaDto(){

    };

    public RespostaDto(Long id, String answer, Long pergunta) {
        this.answer = answer;
        this.pergunta = pergunta;
    }

    public RespostaDto(Resposta entity) {
        this.answer = entity.getAnswer();
        this.pergunta = entity.getPergunta().getId();
    }


    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Long getPergunta() {
        return pergunta;
    }

    public void setPergunta(Long pergunta) {
        this.pergunta = pergunta;
    }
}
