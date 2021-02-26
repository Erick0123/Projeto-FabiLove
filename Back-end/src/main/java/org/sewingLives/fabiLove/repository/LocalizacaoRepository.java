package org.sewingLives.fabiLove.repository;

import java.util.List;

import org.sewingLives.fabiLove.model.Localizacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalizacaoRepository extends JpaRepository<Localizacao, Long>{
	public List<Localizacao> findAllByNomeContainingIgnoreCase(String nome);
}
