package com.engsoft.spring.jpa.postgresql.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.engsoft.spring.jpa.postgresql.model.ResponseUsuario;
import com.engsoft.spring.jpa.postgresql.model.Usuario;
import com.engsoft.spring.jpa.postgresql.model.UsuarioLogin;
import com.engsoft.spring.jpa.postgresql.model.UsuarioLogout;
import com.engsoft.spring.jpa.postgresql.repository.UsuarioRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;

	@PostMapping("/registro")
	public ResponseEntity<ResponseUsuario> createUsuario(@RequestBody Usuario usuario) {
		try {
			Usuario _usuario = usuarioRepository
					.save(new Usuario(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getSenha(),
							false));
			ResponseUsuario _usuarioResponse = new ResponseUsuario(_usuario.getEmail(), _usuario.getNome(),
					_usuario.getLogado(), _usuario.getId());
			return new ResponseEntity<>(_usuarioResponse, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/login")
	public ResponseEntity<ResponseUsuario> login(@RequestBody UsuarioLogin usuario) {
		try {
			Usuario _usuario = usuarioRepository.findByEmailAndSenha(usuario.getEmail(), usuario.getSenha());

			if (_usuario == null) {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
			Optional<Usuario> usuarioData = usuarioRepository.findById(_usuario.getId());
			usuario.setLogado(true);
			ResponseUsuario _usuarioResponse = new ResponseUsuario(_usuario.getEmail(), _usuario.getNome(),
					_usuario.getLogado(), _usuario.getId());
			_usuarioResponse.setLogado(true);
			Usuario _usuarioData = usuarioData.get();
			_usuarioData.setLogado(true);
			usuarioRepository.save(_usuarioData);
			return new ResponseEntity<>(_usuarioResponse, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/logout")
	public ResponseEntity<ResponseUsuario> logout(@RequestBody UsuarioLogout usuario) {
		try {
			Usuario _usuario = usuarioRepository.findByEmailAndSenha(usuario.getEmail(), usuario.getSenha());

			if (_usuario == null) {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
			Optional<Usuario> usuarioData = usuarioRepository.findById(_usuario.getId());
			ResponseUsuario _usuarioResponse = new ResponseUsuario(_usuario.getEmail(), _usuario.getNome(),
					_usuario.getLogado(), _usuario.getId());
			_usuarioResponse.setLogado(false);
			Usuario _usuarioData = usuarioData.get();
			_usuarioData.setLogado(false);
			usuarioRepository.save(_usuarioData);
			return new ResponseEntity<>(_usuarioResponse, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
