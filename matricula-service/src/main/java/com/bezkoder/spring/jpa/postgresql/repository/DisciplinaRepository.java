package com.bezkoder.spring.jpa.postgresql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.jpa.postgresql.model.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
}
