package br.com.devs.Nexo.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * Classe tema utilizada como entidade para as postagens no Banco de dados.
 * 
 * @since 1.0
 * @author Bianca Campos.
 *
 */

@Entity
@Table(name = "tb_postagem")
public class Postagem {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id_postagem;
	
		@NotNull
		@Size(min = 5, max = 100)
		private String nomePostagem;
		
		@NotNull
		@Size(min = 5, max = 500 )
		public String pitch;
		
		@Temporal(TemporalType.TIMESTAMP)
		private Date data = new java.sql.Date(System.currentTimeMillis());
		
		@ManyToOne
		@JsonIgnoreProperties("listaPostagem")
		private Tema postagemTema;
		
		@ManyToOne
		@JsonIgnoreProperties("postagem")
		private Usuario postagemUsuario;

		public long getId_postagem() {
			return id_postagem;
		}

		public void setId_postagem(long id_postagem) {
			this.id_postagem = id_postagem;
		}

		public String getNomePostagem() {
			return nomePostagem;
		}

		public void setNomePostagem(String nomePostagem) {
			this.nomePostagem = nomePostagem;
		}

		public String getPitch() {
			return pitch;
		}

		public void setPitch(String pitch) {
			this.pitch = pitch;
		}

		public Date getData() {
			return data;
		}

		public void setData(Date data) {
			this.data = data;
		}

		public Usuario getPostagemUsuario() {
			return postagemUsuario;
		}

		public void setPostagemUsuario(Usuario postagemUsuario) {
			this.postagemUsuario = postagemUsuario;
		}

		public Tema getPostagemTema() {
			return postagemTema;
		}

		public void setPostagemTema(Tema postagemTema) {
			this.postagemTema = postagemTema;
		}
		
		
}

	
/*
	@NotNull
	@Size(min = 10, max = 500)
	private String interesses;
	@NotNull
	@Size(min = 10, max = 500)
	public int candidato;*/
	


