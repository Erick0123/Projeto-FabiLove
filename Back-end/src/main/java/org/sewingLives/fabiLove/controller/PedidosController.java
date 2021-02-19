package org.sewingLives.fabiLove.controller;

import java.util.List;

import org.sewingLives.fabiLove.model.Pedidos;
import org.sewingLives.fabiLove.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin("*")
public class PedidosController {

	@Autowired
	public PedidosRepository pedidosRepository;

	@GetMapping("/todos")
	public ResponseEntity<List<Pedidos>> getAll(){
		return ResponseEntity.ok(pedidosRepository.findAll());
	}

}
