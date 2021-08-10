package br.com.devs.Nexo.Services;

import java.nio.charset.Charset;

import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import br.com.devs.Nexo.model.Usuario;
import br.com.devs.Nexo.model.UsuarioDTO;
import br.com.devs.Nexo.Repository.UsuarioRepository;

@Service
public class UsuarioServices {

	private @Autowired UsuarioRepository repositorio;

	public Optional<Object> cadastrarUsuario(Usuario novoUsuario) {
		return repositorio.findByEmail(novoUsuario.getEmail()).map(usuarioExistente -> {
			return Optional.empty();
		}).orElseGet(() -> {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String senhaCriptografada = encoder.encode(novoUsuario.getSenha());
			novoUsuario.setSenha(senhaCriptografada);
			return Optional.ofNullable(repositorio.save(novoUsuario));
		});
	}


	public Optional<Object> cadastrarUsuario2(Usuario novoUsuario) {
		Optional<Usuario> usuario = repositorio.findByEmail(novoUsuario.getEmail());
		if (usuario.isPresent()) {
			return Optional.empty();
		} else {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String senhaCriptografada = encoder.encode(novoUsuario.getSenha());
			novoUsuario.setSenha(senhaCriptografada);
			return Optional.ofNullable(repositorio.save(novoUsuario));
		}
	}

	public Optional<?> pegarCredenciais(UsuarioDTO usuarioParaAutenticar) {
		return repositorio.findByEmail(usuarioParaAutenticar.getEmail()).map(usuarioExistente -> {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

			if (encoder.matches(usuarioParaAutenticar.getSenha(), usuarioExistente.getSenha())) {
				String estruturaBasic = usuarioParaAutenticar.getEmail() + ":" + usuarioParaAutenticar.getSenha(); 
				byte[] autorizacaoBase64 = Base64.encodeBase64(estruturaBasic.getBytes(Charset.forName("US-ASCII"))); 
				String autorizacaoHeader = "Basic " + new String(autorizacaoBase64);

				usuarioParaAutenticar.setToken(autorizacaoHeader);
				usuarioParaAutenticar.setId(usuarioExistente.getId_usuario());
				usuarioParaAutenticar.setNome(usuarioExistente.getNome());
				usuarioParaAutenticar.setSenha(usuarioExistente.getSenha());
				usuarioParaAutenticar.setTipo(usuarioExistente.getTipo());
				return Optional.ofNullable(usuarioParaAutenticar);
			} else {
				return Optional.empty();
			}
		}).orElseGet(() -> {
			return Optional.empty();
		});
	}

	public Optional<?> alterarUsuario(UsuarioDTO usuarioParaAlterar) {
		return repositorio.findById(usuarioParaAlterar.getId()).map(usuarioExistente -> {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String senhaCriptografada = encoder.encode(usuarioParaAlterar.getSenha());
			
			usuarioExistente.setNome(usuarioParaAlterar.getNome());
			usuarioExistente.setSenha(senhaCriptografada);
			return Optional.ofNullable(repositorio.save(usuarioExistente));
		}).orElseGet(() -> {
			return Optional.empty();
		});
	}
}
