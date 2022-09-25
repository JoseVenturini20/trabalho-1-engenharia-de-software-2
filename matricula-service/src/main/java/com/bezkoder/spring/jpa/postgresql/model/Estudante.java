package com.bezkoder.spring.jpa.postgresql.model;

import javax.persistence.*;

@Entity
@Table(name = "estudantes")
public class Estudante {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "matricula")
	private long matricula;

	@Column(name = "nome")
	private String nome;

	@Column(name = "endereco")
	private String endereco;

	@Column(name = "documento")
	private String documento;

	public Estudante() {

	}

	public Estudante(String nome, String endereco, String documento) {
		this.nome = nome;
		this.endereco = endereco;
		this.documento = documento;
	}

	public long getMatricula() {
		return matricula;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento() {
		this.documento = documento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Tutorial [matricula=" + matricula + ", nome=" + nome + ", endereco=" + endereco + "]";
	}

}
