package br.com.devs.Nexo.Controller;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.devs.Nexo.Repository.UsuarioRepository;
import br.com.devs.Nexo.Services.UsuarioServices;
import br.com.devs.Nexo.model.Usuario;
import br.com.devs.Nexo.model.UsuarioDTO;

/**
 * Classe controladora onde são onde estão mapeados os EndPoints relacionados a classe
 * usuário na aplicação. 
 * 
 * @author Felipe Gustavo
 *
 */


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repositorio;

	@Autowired
	private UsuarioServices servicos;

	@PostMapping("/cadastrar")
	public ResponseEntity<Object> cadastrarUsuario(@Valid @RequestBody Usuario novoUsuario) {
		Optional<Object> objetoCadastrado = servicos.cadastrarUsuario(novoUsuario);

		if (objetoCadastrado.isPresent()) {
			return ResponseEntity.status(201).body(objetoCadastrado.get());
		} else {
			return ResponseEntity.status(400).build();
		}

	}

	@PutMapping("/entrar")
	public ResponseEntity<Object> pegarCredenciais(@Valid @RequestBody UsuarioDTO loginSenha) {
		Optional<?> objetoCredenciado = servicos.pegarCredenciais(loginSenha);

		if (objetoCredenciado.isPresent()) {
			return ResponseEntity.status(201).body(objetoCredenciado.get());
		} else {
			return ResponseEntity.status(400).build();
		}
		
	}

	@GetMapping("/todes")
	public ResponseEntity<Object> buscarTodes() {
		List<Usuario> listaUsuarios = repositorio.findAll();
		
		if (listaUsuarios.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listaUsuarios);
		}
		
	}

	@GetMapping("/{id_usuario}")
	public ResponseEntity<Usuario> buscarPorId(@PathVariable(value = "id_usuario") Long id) {
		return ResponseEntity.status(200).body(repositorio.findById(id).get());
	}

	@GetMapping("/pesquisa")
	public ResponseEntity<List<Usuario>> buscarPorNome(@RequestParam(defaultValue = "") String nome) {
		return ResponseEntity.status(200).body(repositorio.findAllByNomeContainingIgnoreCase(nome));
	}

	@PutMapping("/alterar")
	public ResponseEntity<Object> alterar(@Valid @RequestBody UsuarioDTO novoUsuario) {
		Optional<?> objetoAlterado = servicos.alterarUsuario(novoUsuario);

		if (objetoAlterado.isPresent()) {
			return ResponseEntity.status(201).body(objetoAlterado.get());
		} else {
			return ResponseEntity.status(400).build();
		}
	}

	@DeleteMapping("/deletar/{idUsuario}")
	public ResponseEntity<String> deletarPorId(@PathVariable Long idUsuario) {
		Optional<Usuario> usuarioExistente = repositorio.findById(idUsuario);
		if (usuarioExistente.isPresent()) {
			repositorio.deleteById(idUsuario);
			return ResponseEntity.status(200).build();
		} else {
			return ResponseEntity.status(400).build();
		}
	}
}
