package com.bezkoder.spring.jpa.postgresql.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.jpa.postgresql.model.Disciplina;
import com.bezkoder.spring.jpa.postgresql.model.Estudante;
import com.bezkoder.spring.jpa.postgresql.repository.DisciplinaRepository;
import com.bezkoder.spring.jpa.postgresql.repository.EstudanteRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/disciplina")
public class DisciplinaController {
	@Autowired
	DisciplinaRepository disciplinaRepository;
  @PostMapping("/test")
  public ResponseEntity<Disciplina> createDisciplina(@RequestBody Disciplina estudante) {
    try {
      System.out.println(estudante.toString());
      Disciplina _estudante = disciplinaRepository
          .save(new Disciplina(estudante.getCodigoDisciplina(), estudante.getHorario(), estudante.getNome(), estudante.getTurma()));
      return new ResponseEntity<>(_estudante, HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e.toString());
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
