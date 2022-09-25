package com.bezkoder.spring.jpa.postgresql.model;

import javax.persistence.*;

@Entity
@Table(name = "matricula")
public class Matricula {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

  @Column(name = "disciplina_id")
	private long disciplina;

  @Column(name = "estudante_id")
	private long estudante;

	public Matricula() {

	}


	public Matricula(long disciplina, long estudante) {
    this.disciplina = disciplina;
    this.estudante = estudante;
  }


  @Override
	public String toString() {
		return "Tutorial [disciplina=" + disciplina + ", estudante=" + estudante + "]";
	}


  public long getId() {
    return id;
  }


  public long getDisciplina() {
    return disciplina;
  }


  public void setDisciplina(long disciplina) {
    this.disciplina = disciplina;
  }


  public long getEstudante() {
    return estudante;
  }


  public void setEstudante(long estudante) {
    this.estudante = estudante;
  }

}
