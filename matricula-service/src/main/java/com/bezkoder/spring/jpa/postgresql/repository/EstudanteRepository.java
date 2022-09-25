package com.bezkoder.spring.jpa.postgresql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.jpa.postgresql.model.Estudante;

public interface EstudanteRepository extends JpaRepository<Estudante, Long> {
  List<Estudante> findByNomeContaining(String nome);
}
