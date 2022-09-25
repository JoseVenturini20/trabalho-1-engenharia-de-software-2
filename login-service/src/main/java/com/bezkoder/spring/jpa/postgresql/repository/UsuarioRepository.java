package com.bezkoder.spring.jpa.postgresql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.jpa.postgresql.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
  List<Usuario> findByNomeContaining(String nome);
}
