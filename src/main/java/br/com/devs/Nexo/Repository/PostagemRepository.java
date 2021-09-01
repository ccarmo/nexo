package br.com.devs.Nexo.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
	
	@Query(value = "select count(tema_id) from tb_postagens where tema_id = :id", nativeQuery = true)
	public int countPosts2(@Param("id") long id); //consulta nativa - conta o numero de postagens por tema;
}

