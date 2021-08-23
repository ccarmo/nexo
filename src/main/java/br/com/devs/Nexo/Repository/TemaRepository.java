package br.com.devs.Nexo.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.devs.Nexo.model.Tema;

/**
 * Metodo utilizado para selecionar apenas um tema pelo titulo (Chave unica).
 * 
 * @param nome
 * @return List com todos os titulos
 * @since 1.0
 * @author Lucas Queiroz.
 */

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long>
{
	public List<Tema> findAllByNomeTemaContainingIgnoreCase (String nomeTema);
}
