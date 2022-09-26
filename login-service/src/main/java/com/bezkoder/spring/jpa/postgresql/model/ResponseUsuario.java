package com.bezkoder.spring.jpa.postgresql.model;

public class ResponseUsuario {
    private String email;
    private String nome;
    private Boolean logado;
    private Long id;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ResponseUsuario(String email, String nome, Boolean logado, Long id) {
        this.email = email;
        this.nome = nome;
        this.logado = logado;
        this.id = id;
    }

    public Boolean getLogado() {
        return logado;
    }

    public void setLogado(Boolean logado) {
        this.logado = logado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
