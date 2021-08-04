package br.com.devs.Nexo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usuario;
	
	@NotNull
	@Size(min = 5, max = 100)
	private String nome;
	
	@NotNull
	private int idade;
	
	@NotNull
	private Float  renda_familiar;
	
	@NotNull
	private String ramo_empresa;
	
	@OneToMany(mappedBy = "postagemUsuario", cascade = CascadeType.ALL)
	@JsonIgnoreProperties ("postagemUsuario")
	private List<Postagem> postagem;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	@JsonIgnoreProperties ("usuario")
	private List<Tema> tema;
	
	
	/*private enum  tipo {empresa,candidato}*/
	
	
	public Long getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public Float getRenda_familiar() {
		return renda_familiar;
	}
	public void setRenda_familiar(Float renda_familiar) {
		this.renda_familiar = renda_familiar;
	}
	public String getRamo_empresa() {
		return ramo_empresa;
	}
	public void setRamo_empresa(String ramo_empresa) {
		this.ramo_empresa = ramo_empresa;
	}
	public List<Postagem> getPostagem() {
		return postagem;
	}
	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}
	public List<Tema> getTema() {
		return tema;
	}
	public void setTema(List<Tema> tema) {
		this.tema = tema;
	}
	
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
