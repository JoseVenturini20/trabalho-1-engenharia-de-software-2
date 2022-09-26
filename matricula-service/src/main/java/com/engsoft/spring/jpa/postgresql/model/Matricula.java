package com.engsoft.spring.jpa.postgresql.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "matricula")
public class Matricula {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

  @ManyToOne()
  private Disciplina disciplina;
	

  @ManyToOne()
	private Estudante estudante;

	public Matricula() {

	}


	public Matricula(Disciplina disciplina, Estudante estudante) {
    this.disciplina = disciplina;
    this.estudante = estudante;
  }


  @Override
	public String toString() {
		return "Tutorial [disciplina=" + disciplina.getCodigoDisciplina() + ", estudante=" + estudante.getMatricula() + "]";
	}


  public long getId() {
    return id;
  }


  public Disciplina getDisciplina() {
    return disciplina;
  }


  public void setDisciplina(Disciplina disciplina) {
    this.disciplina = disciplina;
  }


  public Estudante getEstudante() {
    return estudante;
  }


  public void setEstudante(Estudante estudante) {
    this.estudante = estudante;
  }

}
