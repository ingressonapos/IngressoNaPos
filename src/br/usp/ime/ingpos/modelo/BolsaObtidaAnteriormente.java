package br.usp.ime.ingpos.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BolsaObtidaAnteriormente {
	@Id
	@GeneratedValue
	private long bolsaId;
	@Column(length=50)
	private String tipoBolsa;
	@Column(length=50)
	private String nomeInstituicao; //Instituicao que concedeu a bolsa
	@Column
	private int duracao;
	@Column(length=50)
	private String nomeOrientador;
	@Column(length=50)
	private String nomeProjeto;
	public long getBolsaId() {
		return bolsaId;
	}
	public void setBolsaId(long bolsaId) {
		this.bolsaId = bolsaId;
	}
	public String getTipoBolsa() {
		return tipoBolsa;
	}
	public void setTipoBolsa(String tipoBolsa) {
		this.tipoBolsa = tipoBolsa;
	}
	public String getNomeInstituicao() {
		return nomeInstituicao;
	}
	public void setNomeInstituicao(String nomeInstituicao) {
		this.nomeInstituicao = nomeInstituicao;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	public String getNomeOrientador() {
		return nomeOrientador;
	}
	public void setNomeOrientador(String nomeOrientador) {
		this.nomeOrientador = nomeOrientador;
	}
	public String getNomeProjeto() {
		return nomeProjeto;
	}
	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
	}
	
}

