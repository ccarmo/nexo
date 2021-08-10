package br.com.devs.Nexo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.devs.Nexo.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	/**
	 * Metodo utilizado para selecionar apenas um Usuario pelo email (Chave unica)
	 * 
	 * @param email
	 * @return Optional com Usuario unico
	 * @since 1.0
	 * @author Fernanda
	 */
	Optional<Usuario> findByEmail(String email);
    
	/**
	 * Metodo utilizado para pesquisar coluna nome da tabela Usuario
	 * 
	 * @param nome
	 * @return Lista de Usuario
	 * @since 1.0
	 * @author Fernanda
	 */
	List<Usuario> findAllByNomeContainingIgnoreCase(String nome);

}
