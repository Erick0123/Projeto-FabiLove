package org.sewingLives.fabiLove.controller;

import java.util.List;

import org.sewingLives.fabiLove.model.Categoria;
import org.sewingLives.fabiLove.repository.CategoriaRepository;
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
@RequestMapping("/categoria")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {

	// -----------------injeção do repositorio
	// categoria----------------------------//
	@Autowired
	public CategoriaRepository categoriaRepository;

	// ---------------------------CRUD----------------------------//

	// -----------Get mostrando todos, um por id ou um por nome-------------------//
	@GetMapping("/todos")
	public ResponseEntity<List<Categoria>> getAll() {
		return ResponseEntity.ok(categoriaRepository.findAll());
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<Categoria> GetById(@PathVariable Long id) {
		return categoriaRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Categoria>> getByNome(@PathVariable String nome) {
		return ResponseEntity.ok(categoriaRepository.findAllByNomeContainingIgnoreCase(nome));
	}

	// --------------------Post: inserção, publicando
	// algo-------------------------//
	@PostMapping("/post")
	public ResponseEntity<Categoria> post(@RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));
	}

	// ----------------CRUD Put------------------------------//
	@PutMapping("/put/{id}")
	public Categoria put(@PathVariable Long id, @RequestBody Categoria categoria) {
		categoria.setId(id);
		categoriaRepository.save(categoria);
		return categoria;
	}

	// ----------------CRUD Delete------------------------------//
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		try {
			categoriaRepository.deleteById(id);
			return "Deletado!";
		} catch (Exception e) {
			return "Erro: " + e.getLocalizedMessage();
		}
	}
}
