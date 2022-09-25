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
@RequestMapping("/api")
public class TutorialController {

	@Autowired
	EstudanteRepository tutorialRepository;
	DisciplinaRepository disciplinaRepository;

	@GetMapping("/tutorials")
	public ResponseEntity<List<Estudante>> getAllTutorials(@RequestParam(required = false) String nome) {
		try {
			List<Estudante> tutorials = new ArrayList<Estudante>();

			if (nome == null)
				tutorialRepository.findAll().forEach(tutorials::add);
			else
				tutorialRepository.findByNomeContaining(nome).forEach(tutorials::add);

			if (tutorials.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(tutorials, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/tutorials/{id}")
	public ResponseEntity<Estudante> getTutorialById(@PathVariable("id") long id) {
		Optional<Estudante> tutorialData = tutorialRepository.findById(id);

		if (tutorialData.isPresent()) {
			return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/tutorials")
	public ResponseEntity<Estudante> createTutorial(@RequestBody Estudante tutorial) {
		try {
			Estudante _tutorial = tutorialRepository
					.save(new Estudante(tutorial.getNome(), tutorial.getEndereco()));
			return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/test")
	public ResponseEntity<Disciplina> createDisciplina(@RequestBody Disciplina tutorial) {
		try {
			Disciplina _tutorial = disciplinaRepository
					.save(new Disciplina(tutorial.getCodigoDisciplina(), tutorial.getHorario(), tutorial.getNome(), tutorial.getTurma()));
			return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/tutorials/{id}")
	public ResponseEntity<Estudante> updateTutorial(@PathVariable("id") long id, @RequestBody Estudante tutorial) {
		Optional<Estudante> tutorialData = tutorialRepository.findById(id);

		if (tutorialData.isPresent()) {
			Estudante _tutorial = tutorialData.get();
			_tutorial.setNome(tutorial.getNome());
			_tutorial.setEndereco(tutorial.getEndereco());
			return new ResponseEntity<>(tutorialRepository.save(_tutorial), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/tutorials/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
		try {
			tutorialRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/tutorials")
	public ResponseEntity<HttpStatus> deleteAllTutorials() {
		try {
			tutorialRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
