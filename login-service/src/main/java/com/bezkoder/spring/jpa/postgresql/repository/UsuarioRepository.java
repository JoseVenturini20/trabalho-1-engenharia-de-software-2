package com.bezkoder.spring.jpa.postgresql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.jpa.postgresql.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
  Usuario findByEmailAndSenha(String email, String senha);
}
