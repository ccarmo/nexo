package br.com.devs.Nexo.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import br.com.devs.Nexo.model.utilidades.TipoUsuario;

/**
 * Classe DTO modelo para Logar e Alterar usuario.
 * Para login: necessario apenas email e senha como atributos; 
 * Para Alterar: necessario o id para alterar nome e senha;  
 * 
 * @since 1.0
 * @author Felipe Gustavo
 *
 */

public class UsuarioDTO {

	private Long id;

	private String nome;

	@NotBlank(message = "Necessario Email")
	@Email(message = "Necessario Email")
	private String email;

	@Size(min = 5, max = 100, message = "Minímo 5 caracteres")
	private String senha;

	private String token;

	private TipoUsuario tipo;
	
	private String foto;

	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

}
