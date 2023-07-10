package com.oxigenybackend.question.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String img;

    @OneToMany(mappedBy = "usuario")
    private List<Resposta> respostas = new ArrayList<>();

    @OneToMany(mappedBy = "usuario")
    private List<Pergunta> perguntas = new ArrayList<>();

    @JsonIgnore
    @Column(columnDefinition = "TEXT")
    private Object hibernateLazyInitializer;

    public Usuario() {
    }

    public Usuario(String nome, String email, String senha, String img) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.img = img;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
