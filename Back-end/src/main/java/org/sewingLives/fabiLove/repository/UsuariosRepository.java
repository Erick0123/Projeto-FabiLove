package org.sewingLives.fabiLove.repository;

import java.util.List;

import org.sewingLives.fabiLove.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long>{
	public List<Usuarios> findAllByNomeContainigIgnoreCase(String Nome);
}
