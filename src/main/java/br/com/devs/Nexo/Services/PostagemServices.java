package br.com.devs.Nexo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import br.com.devs.Nexo.model.Postagem;
import br.com.devs.Nexo.Repository.PostagemRepository;

/**
 * Método utilizado para cadastrar uma postagem nova no banco validando se o
 * usuario criador é existente. O id do usuario criador e o id do tema deve ser
 * passado dentro do objeto postagem para que a criação seja efetuada. Caso id
 * do usuario não for passado ou não existir no banco retorna um
 * Optional.empty()
 * 
 * @param novaPostagem do tipo Postagem
 * @return Optional com Postagem
 * @since 1.0
 * @author Carlos Henrique.
 */

@Service
public class PostagemServices {

	@Autowired
	private PostagemRepository postagemRepository;

	
	public Postagem curtir(Long id) { // regra de negocio para curtir postagem;
		Postagem postagem = buscarPostagemPeloId(id);
		postagem.setCurtidas(postagem.getCurtidas() + 1);
		return postagemRepository.save(postagem);

		}

	public Postagem descurtir(Long id) { // regra de negocio para descurtir postagem;

		Postagem postagem = buscarPostagemPeloId(id);

		if (postagem.getCurtidas() > 0) {

			postagem.setCurtidas(postagem.getCurtidas() - 1);

		} else {

			postagem.setCurtidas(0);

		}

		return postagemRepository.save(postagem);

		}

	private Postagem buscarPostagemPeloId(Long id) {

		Postagem postagemSalva = postagemRepository.findById(id).orElse(null);

		if (postagemSalva == null) {

			throw new EmptyResultDataAccessException(1);
		}

		return postagemSalva;
	}
}
