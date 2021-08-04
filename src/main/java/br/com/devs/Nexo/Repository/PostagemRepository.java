package br.com.devs.Nexo.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.devs.Nexo.model.Postagem;


@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long>
{
	public List<Postagem> findAllByNomePostagemContainingIgnoreCase (String nomePostagem);
}