package br.usp.ime.ingpos.modelo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


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
	private BolsaObtidaAnteriormente bolsa;
	
	
	public BolsaObtidaAnteriormente getBolsa() {
		return bolsa;
	}
	public void setBolsa(BolsaObtidaAnteriormente bolsa) {
		this.bolsa = bolsa;
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
