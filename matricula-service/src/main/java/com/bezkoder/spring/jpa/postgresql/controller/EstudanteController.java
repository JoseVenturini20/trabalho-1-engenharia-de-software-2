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
@RequestMapping("/api/estudantes")
public class EstudanteController {

	@Autowired
	EstudanteRepository estudanteRepository;
	@Autowired
	DisciplinaRepository disciplinaRepository;

	@GetMapping("")
	public ResponseEntity<List<Estudante>> getAllEstudantes(@RequestParam(required = false) String nome) {
		try {
			List<Estudante> estudantes = new ArrayList<Estudante>();

			if (nome == null)
				estudanteRepository.findAll().forEach(estudantes::add);
			else
				estudanteRepository.findByNomeContaining(nome).forEach(estudantes::add);

			if (estudantes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(estudantes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Estudante> getEstudanteById(@PathVariable("id") long id) {
		Optional<Estudante> estudanteData = estudanteRepository.findById(id);

		if (estudanteData.isPresent()) {
			return new ResponseEntity<>(estudanteData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/create")
	public ResponseEntity<Estudante> createEstudante(@RequestBody Estudante estudante) {
		try {
			Estudante _estudante = estudanteRepository
					.save(new Estudante(estudante.getNome(), estudante.getEndereco()));
			return new ResponseEntity<>(_estudante, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@PutMapping("/{id}")
	public ResponseEntity<Estudante> updateEstudante(@PathVariable("id") long id, @RequestBody Estudante estudante) {
		Optional<Estudante> estudanteData = estudanteRepository.findById(id);

		if (estudanteData.isPresent()) {
			Estudante _estudante = estudanteData.get();
			_estudante.setNome(estudante.getNome());
			_estudante.setEndereco(estudante.getEndereco());
			return new ResponseEntity<>(estudanteRepository.save(_estudante), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteEstudante(@PathVariable("id") long id) {
		try {
			estudanteRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/all")
	public ResponseEntity<HttpStatus> deleteAllEstudantes() {
		try {
			estudanteRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
