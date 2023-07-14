package com.oxigenybackend.question.dto;

import com.oxigenybackend.question.model.Resposta;

public class RespostaDTOOut {
    private String answer;
    private UsuarioRespostaDto usuario;

    public RespostaDTOOut(){

    };

    public RespostaDTOOut(Long id,UsuarioRespostaDto usuario) {
        this.answer = answer;
        this.usuario = usuario;

    }

    public RespostaDTOOut(Resposta entity) {
        this.answer = entity.getAnswer();
        UsuarioRespostaDto usuario = new UsuarioRespostaDto();
        usuario.setNome(entity.getUsuario().getNome());
        usuario.setId(entity.getUsuario().getId());
        this.usuario = usuario;
    }
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public UsuarioRespostaDto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioRespostaDto usuario) {
        this.usuario = usuario;
    }
}


