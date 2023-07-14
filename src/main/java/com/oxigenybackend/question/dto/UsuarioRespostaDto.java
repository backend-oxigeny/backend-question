package com.oxigenybackend.question.dto;
import com.oxigenybackend.question.model.Usuario;

public class UsuarioRespostaDto {
    private Long id;
    private String nome;

    public UsuarioRespostaDto() {
    }

    public UsuarioRespostaDto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    public UsuarioRespostaDto(Usuario entity){
        id = entity.getId();
        nome = entity.getNome();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
