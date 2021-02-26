package org.sewingLives.fabiLove.repository;

import java.util.List;
import java.util.Optional;

import org.sewingLives.fabiLove.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuariosRepository extends JpaRepository<Usuarios, Long>{
	public List<Usuarios> findAllByNomeContainingIgnoreCase(String Nome);
	public Optional<Usuarios>findByNome(String nome);
}
