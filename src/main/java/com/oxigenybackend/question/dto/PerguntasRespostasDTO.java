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
    private UsuarioRespostaDto usuario;
    private List<RespostaDTOOut> respostas = new ArrayList<>();

    public PerguntasRespostasDTO() {
    }

    public PerguntasRespostasDTO(Pergunta pergunta, Long id, String question, UsuarioRespostaDto usuario) {
        this.question = question;
        this.id = id;
        this.usuario = usuario;
    }
    public PerguntasRespostasDTO(Pergunta entity){
        this.question = entity.getQuestion();
        this.id = entity.getId();
        entity.getRespostas().forEach(f -> respostas.add(new RespostaDTOOut(f)));
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

    public List<RespostaDTOOut> getRespostasDTO() {
        return respostas;
    }

}
