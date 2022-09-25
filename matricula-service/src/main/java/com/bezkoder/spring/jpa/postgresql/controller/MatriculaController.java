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
import com.bezkoder.spring.jpa.postgresql.model.Matricula;
import com.bezkoder.spring.jpa.postgresql.model.MatriculaReq;
import com.bezkoder.spring.jpa.postgresql.repository.DisciplinaRepository;
import com.bezkoder.spring.jpa.postgresql.repository.EstudanteRepository;
import com.bezkoder.spring.jpa.postgresql.repository.MatriculaRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/matricula")
public class MatriculaController {

	@Autowired
	EstudanteRepository estudanteRepository;
	@Autowired
	DisciplinaRepository disciplinaRepository;
  @Autowired
  MatriculaRepository matriculaRepository;

	@PostMapping("/matricula")
	public ResponseEntity<List<Estudante>> addEstudanteDisciplina(@RequestBody(required = true) MatriculaReq matriculaReq) {
		try {
			Estudante estudante = estudanteRepository.findById(matriculaReq.getMatriculaEstudante()).get();
			if (estudante == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
      Disciplina disciplina = disciplinaRepository.findByCodigoDisciplinaAndTurma(matriculaReq.getCodigoDisciplina(), matriculaReq.getTurma());
      if (disciplina == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
      Matricula _matricula = matriculaRepository
      .save(new Matricula(disciplina.getId(), estudante.getMatricula()));
    return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}
