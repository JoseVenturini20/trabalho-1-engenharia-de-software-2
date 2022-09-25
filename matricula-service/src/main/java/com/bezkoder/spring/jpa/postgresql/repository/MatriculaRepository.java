package com.bezkoder.spring.jpa.postgresql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.jpa.postgresql.model.Disciplina;
import com.bezkoder.spring.jpa.postgresql.model.Estudante;
import com.bezkoder.spring.jpa.postgresql.model.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
  List<Matricula> findByEstudante (Estudante estudante);
  List<Matricula> findByDisciplina (Disciplina disciplina);
}
