package org.sewingLives.fabiLove.repository;

import java.util.List;

import org.sewingLives.fabiLove.model.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Long>{
	public List<Produtos> findAllByNomeContainingIgnoreCase(String nome);
}
