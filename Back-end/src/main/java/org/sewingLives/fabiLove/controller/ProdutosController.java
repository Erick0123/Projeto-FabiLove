package org.sewingLives.fabiLove.controller;

import java.util.List;

import org.sewingLives.fabiLove.model.Produtos;
import org.sewingLives.fabiLove.repository.ProdutosRepository;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins="*", allowedHeaders = "*")
public class ProdutosController {
	
	//-----------------injeção do repositorio produto----------------------------//
	@Autowired
	public ProdutosRepository produtosRepository;
	
	//-----------------CRUD Get----------------------------//
	
	//Buscando todos, por id ou por nome
	
	@GetMapping("/todos")
	public ResponseEntity<List<Produtos>> getAll(){
		return ResponseEntity.ok(produtosRepository.findAll());
	}
	
	@GetMapping("id/{id}")
	public ResponseEntity<Produtos> GetById(@PathVariable Long id){
		return produtosRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Produtos>> GetByNome(@PathVariable String nome){
		return ResponseEntity.ok(produtosRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	//-----------------CRUD Post-------------------------------//
	@PostMapping("/post")
	public ResponseEntity<Produtos> post(@RequestBody Produtos produtos){
		return ResponseEntity.status(HttpStatus.CREATED).body(produtosRepository.save(produtos));
	}
	//----------------CRUD Put------------------------------//
	@PutMapping("/put/{id}")
	public Produtos put(@RequestBody Produtos produtos, @PathVariable Long id){
	 produtos.setId(id);
	 produtosRepository.save(produtos);
	 return produtos;

		
	}
	@DeleteMapping("/delete/{id}")
	public String delete (@PathVariable Long id){
		try{
			produtosRepository.deleteById(id);
			return "Deletado!";
		}catch(Exception e){
			return "Erro: "+e.getLocalizedMessage();
		}
	}
}
