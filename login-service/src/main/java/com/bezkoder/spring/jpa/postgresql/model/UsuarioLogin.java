package com.bezkoder.spring.jpa.postgresql.model;

public class UsuarioLogin {
    private String email;
    private String senha;
    private Boolean logado;

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

    public UsuarioLogin(String email, String senha, Boolean logado) {
        this.email = email;
        this.senha = senha;
        this.logado = logado;
    }

    public Boolean getLogado() {
        return logado;
    }

    public void setLogado(Boolean logado) {
        this.logado = logado;
    }

}
