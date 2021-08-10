package br.com.devs.Nexo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_tema")
public class Tema {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
	@OneToMany(mappedBy = "postagemTema", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("postagemTema")
	private List<Postagem> listaPostagem;
			
	@ManyToOne
	@JsonIgnoreProperties("tema")
	private Usuario usuario;
	
    @NotBlank
    @Size(min = 5, max = 100)
	private String nomeTema;
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeTema() {
		return nomeTema;
	}

	public void setNomeTema(String nomeTema) {
		this.nomeTema = nomeTema;
	}

	public List<Postagem> getListaPostagem() {
		return listaPostagem;
	}

	public void setListaPostagem(List<Postagem> listaPostagem) {
		this.listaPostagem = listaPostagem;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
    

}
