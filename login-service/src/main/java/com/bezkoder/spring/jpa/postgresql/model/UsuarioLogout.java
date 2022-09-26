package com.bezkoder.spring.jpa.postgresql.model;

public class UsuarioLogout {
    private String email;
    private String senha;
    private Boolean logado;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UsuarioLogout(String email, Boolean logado, String senha) {
        this.email = email;
        this.logado = logado;
        this.senha = senha;
    }

    public Boolean getLogado() {
        return logado;
    }

    public void setLogado(Boolean logado) {
        this.logado = logado;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
