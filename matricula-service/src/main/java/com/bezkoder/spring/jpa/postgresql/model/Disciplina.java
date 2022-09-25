package com.bezkoder.spring.jpa.postgresql.model;

import javax.persistence.*;

@Entity
@Table(name = "disciplinas")
public class Disciplina {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	@Column(name = "codigo_disciplina")
	private String codigoDisciplina;

  @Column(name = "horario")
	private String horario;

	@Column(name = "nome")
	private String nome;

  @Column(name = "turma")
	private int turma;

	public Disciplina() {

	}

	public long getId() {
    return id;
  }

  public String getCodigoDisciplina() {
    return codigoDisciplina;
  }

  public void setCodigoDisciplina(String codigoDisciplina) {
    this.codigoDisciplina = codigoDisciplina;
  }

  public String getHorario() {
    return horario;
  }

  public void setHorario(String horario) {
    this.horario = horario;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getTurma() {
    return turma;
  }

  public void setTurma(int turma) {
    this.turma = turma;
  }

  public Disciplina(String codigoDisciplina, String horario, String nome, int turma) {
    this.codigoDisciplina = codigoDisciplina;
    this.horario = horario;
    this.nome = nome;
    this.turma = turma;
	}

	@Override
	public String toString() {
		return "Tutorial [codigoDisciplina=" + codigoDisciplina + ", nome=" + nome + ", horario=" + horario + ", turma= " + turma + "]";
	}

}
