package com.bezkoder.spring.jpa.postgresql.model;

public class MatriculaReq {
  private long matriculaEstudante;
  private String codigoDisciplina;
  private int turma;
  public long getMatriculaEstudante() {
    return matriculaEstudante;
  }
  public void setMatriculaEstudante(long matriculaEstudante) {
    this.matriculaEstudante = matriculaEstudante;
  }
  public String getCodigoDisciplina() {
    return codigoDisciplina;
  }
  public void setCodigoDisciplina(String codigoDisciplina) {
    this.codigoDisciplina = codigoDisciplina;
  }
  public int getTurma() {
    return turma;
  }
  public void setTurma(int turma) {
    this.turma = turma;
  }
  public MatriculaReq(long matriculaEstudante, String codigoDisciplina, int turma) {
    this.matriculaEstudante = matriculaEstudante;
    this.codigoDisciplina = codigoDisciplina;
    this.turma = turma;
  }

  
}
