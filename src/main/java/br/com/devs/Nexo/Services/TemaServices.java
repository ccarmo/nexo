package br.com.devs.Nexo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import br.com.devs.Nexo.Repository.TemaRepository;
import br.com.devs.Nexo.model.Tema;


/**
 * Método utilizado para alterar um tema. O mesmo retorna um Optional com Tema
 * caso correto ou um Optional.empyt() caso id do tema não exista.
 * 
 * @param temaParaAlterar do tipo Tema.
 * @return Optional com Tema alterado.
 * @since 1.0
 * @author Lucas Queiroz.
 */

@Service
public class TemaServices {

	@Autowired
	private TemaRepository temaRepository;

	private Tema buscarPostagemPeloId(Long id) {

		Tema temaSalvo = temaRepository.findById(id).orElse(null);

		if (temaSalvo == null) {

			throw new EmptyResultDataAccessException(1);
		}

		return temaSalvo;
	}
}

