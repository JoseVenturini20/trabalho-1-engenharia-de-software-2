package com.engsoft.spring.jpa.postgresql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.engsoft.spring.jpa.postgresql.model.Estudante;

public interface EstudanteRepository extends JpaRepository<Estudante, Long> {
  List<Estudante> findByNomeContaining(String nome);
}
