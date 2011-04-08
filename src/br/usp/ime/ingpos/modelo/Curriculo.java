package br.usp.ime.ingpos.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Curriculo {

	@Id
	@GeneratedValue
	private Long curriculoID;
	@OneToMany
	@JoinColumn(referencedColumnName = "curriculoID")
	private Set<FormacaoAcademica> formacaoAcademica = new HashSet<FormacaoAcademica>();
	@OneToMany
	@JoinColumn(referencedColumnName = "curriculoID")
	private Set<Bolsa> bolsas = new HashSet<Bolsa>();
	@ManyToOne
	private PosComp posComp;
	@OneToMany
	@JoinColumn(referencedColumnName = "curriculoID")
	private Set<IniciacaoCientifica> iniciacaoCientifica = new HashSet<IniciacaoCientifica>();

	public Set<IniciacaoCientifica> getIniciacaoCientifica() {
		return iniciacaoCientifica;
	}
	public void setIniciacaoCientifica(Set<IniciacaoCientifica> iniciacaoCientifica) {
		this.iniciacaoCientifica = iniciacaoCientifica;
	}
	public PosComp getPosComp() {
		return posComp;
	}
	public void setPosComp(PosComp posComp) {
		this.posComp = posComp;
	}
	public Long getCurriculoID() {
		return curriculoID;
	}
	public void setCurriculoID(Long curriculoID) {
		this.curriculoID = curriculoID;
	}
	public Set<FormacaoAcademica> getFormacaoAcademica() {
		return formacaoAcademica;
	}
	public void setFormacaoAcademica(Set<FormacaoAcademica> formacaoAcademica) {
		this.formacaoAcademica = formacaoAcademica;
	}
	public Set<Bolsa> getBolsas() {
		return bolsas;
	}
	public void setBolsas(Set<Bolsa> bolsas) {
		this.bolsas = bolsas;
	}
}
