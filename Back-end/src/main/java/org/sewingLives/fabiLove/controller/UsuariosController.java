package org.sewingLives.fabiLove.controller;

import java.util.List;

import org.sewingLives.fabiLove.model.Usuarios;
import org.sewingLives.fabiLove.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuariosController {

	//injetando o repositorio de usuario//
	@Autowired
	public UsuariosRepository usuarioRepository;
	
	//CRUD get visualização de usuarios do banco de dados
	//aqui eu fiz um get para ver todos os usuarios e logo em baixo um que ver por id
	@GetMapping("/todos")
	public ResponseEntity<List<Usuarios>> getAll(){
		return ResponseEntity.ok(usuarioRepository.findAll());
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Usuarios> GetById(@PathVariable Long id){
		return usuarioRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	
}
