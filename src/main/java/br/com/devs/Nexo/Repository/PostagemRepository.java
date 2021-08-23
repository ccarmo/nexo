package br.com.devs.Nexo.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.devs.Nexo.model.Postagem;

/**
 * Metodo utilizado para pesquisar coluna titulo da tabela postagem.
 * 
 * @param titulo
 * @return Lista de Postagens
 * @since 1.0
 * @author Lucas Queiroz.
 */


@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long>
{
	public List<Postagem> findAllByNomePostagemContainingIgnoreCase (String nomePostagem);
}