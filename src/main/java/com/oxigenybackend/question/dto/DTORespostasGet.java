package com.oxigenybackend.question.dto;

import com.oxigenybackend.question.model.Resposta;

public class DTORespostasGet {
    private Long id;
    private String answer;
    private UsuarioRespostaDto user;
    private PerguntasRespostasDTOGet pergunta;


    public DTORespostasGet() {
    }

    public DTORespostasGet(Long id, String answer, PerguntasRespostasDTOGet perguntas) {
        this.id = id;
        this.answer = answer;
        this.pergunta = perguntas;
    }
    public DTORespostasGet(Resposta entity){
        this.id= entity.getId();
        this.answer = entity.getAnswer();
        UsuarioRespostaDto usuario = new UsuarioRespostaDto();
        usuario.setNome(entity.getPergunta().getUsuario().getNome());
        usuario.setId(entity.getPergunta().getUsuario().getId());
        PerguntasRespostasDTOGet perguntaDto = new PerguntasRespostasDTOGet();
        perguntaDto.setQuestion(entity.getPergunta().getQuestion());
        perguntaDto.setId(entity.getPergunta().getId());
        perguntaDto.setUsuario(usuario);
        user = new UsuarioRespostaDto(entity.getUsuario());
        pergunta = perguntaDto;
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
    public UsuarioRespostaDto getUser() {
        return user;
    }

    public PerguntasRespostasDTOGet getPergunta() {
        return pergunta;
    }

    public void setPergunta(PerguntasRespostasDTOGet perguntas) {
        this.pergunta = perguntas;
    }



    public void setUser(UsuarioRespostaDto user) {
        this.user = user;
    }
}
