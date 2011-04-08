package br.usp.ime.ingpos.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class IniciacaoCientifica {
	@Id
	@GeneratedValue
	private long iniciacaocientificaId;
	@Column(length=50)
	private String nomeOrientador;
	@Column(length=50)
	private String nomeInstituicao;
	@Column(length=50)
	private String temaProjeto;
	
	@ManyToOne
	@JoinColumn(name = "curriculoID")
	private Curriculo curriculo;

	public Curriculo getCurriculo() {
		return curriculo;
	}
	public void setCurriculo(Curriculo curriculo) {
		this.curriculo = curriculo;
	}
	public long getIniciacaocientificaId() {
		return iniciacaocientificaId;
	}
	public void setIniciacaocientificaId(long iniciacaocientificaId) {
		this.iniciacaocientificaId = iniciacaocientificaId;
	}
	public String getNomeOrientador() {
		return nomeOrientador;
	}
	public void setNomeOrientador(String nomeOrientador) {
		this.nomeOrientador = nomeOrientador;
	}
	public String getNomeInstituicao() {
		return nomeInstituicao;
	}
	public void setNomeInstituicao(String nomeInstituicao) {
		this.nomeInstituicao = nomeInstituicao;
	}
	public String getTemaProjeto() {
		return temaProjeto;
	}
	public void setTemaProjeto(String temaProjeto) {
		this.temaProjeto = temaProjeto;
	}
	
	

}
