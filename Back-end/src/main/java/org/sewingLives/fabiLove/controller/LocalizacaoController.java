package org.sewingLives.fabiLove.controller;

import java.util.List;

import org.sewingLives.fabiLove.model.Localizacao;
import org.sewingLives.fabiLove.repository.LocalizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/localizacao")
@CrossOrigin(origins="*", allowedHeaders = "*")
public class LocalizacaoController {

	//-----------------injeção do repositorio Localizacao----------------------------//
	@Autowired
	public LocalizacaoRepository localizacaoRepository;
	
	//-----------------CRUD----------------------------//
	
	//--Metodo get para visualizar todas as localizaçoes ou apenas uma buscando por nome-----//
	
	@GetMapping("/todos")
	public ResponseEntity<List<Localizacao>> getAll(){
		return ResponseEntity.ok(localizacaoRepository.findAll());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Localizacao>> GetByNome(@PathVariable String nome){
		return ResponseEntity.ok(localizacaoRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	//-------------Post: publicar, inserir localizaçao-----------------------------//
	@PostMapping("/post")
	public ResponseEntity<Localizacao> post(@RequestBody Localizacao local){
		return ResponseEntity.status(HttpStatus.CREATED).body(localizacaoRepository.save(local));
	}
}
