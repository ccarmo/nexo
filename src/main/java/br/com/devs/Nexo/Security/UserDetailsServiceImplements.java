package br.com.devs.Nexo.Security;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import br.com.devs.Nexo.Repository.UsuarioRepository;
import br.com.devs.Nexo.model.Usuario;


/**
 * Classe utilizada para validação do usuário no banco de dados.
 * 

 * @since 1.0
 * @author Felipe Gustavo.
 */

@Service
public class UserDetailsServiceImplements implements UserDetailsService {
	
	private @Autowired UsuarioRepository repositorio;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = repositorio.findByEmail(username);
		
		if (usuario.isPresent()) {
			return new UserDetailsImplements(usuario.get());
		} else {
			throw new UsernameNotFoundException(username + " não encontrado.");
		}
	}

}
