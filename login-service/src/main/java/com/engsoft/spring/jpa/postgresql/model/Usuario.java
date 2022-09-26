package com.engsoft.spring.jpa.postgresql.model;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private long id;

	@Column(name = "email")
	private String email;

	@Column(name = "nome")
	private String nome;

	@Column(name = "senha")
	private String senha;

	@Column(name = "logado",columnDefinition = "boolean default false")
	private Boolean logado;

	public Usuario() {

	}

	public Usuario(long id, String nome, String email, String senha, Boolean logado) {
		this.id = id;
		this.nome = nome;
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

	public String getNome() {
		return nome;
	}

	public long getId() {
		return id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setId(long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", email=" + email + ", senha=" + senha + ", logado =" + logado + "]";
	}

}
