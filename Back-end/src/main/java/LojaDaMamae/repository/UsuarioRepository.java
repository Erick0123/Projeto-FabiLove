package LojaDaMamae.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import LojaDaMamae.model.Usuario;

public interface UsuarioRepository extends JpaRepositoryImplementation<Usuario, Long>{
	public List<Usuario> findAllByNomeContainingIgnoreCase(String nome);
	public Optional<Usuario> findByNome(String nome);

}
