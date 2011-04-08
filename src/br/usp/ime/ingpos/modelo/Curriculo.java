package br.usp.ime.ingpos.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

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
	private Set<BolsaObtidaAnteriormente> bolsaAnterior = new HashSet<BolsaObtidaAnteriormente>();

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
	public Set<BolsaObtidaAnteriormente> getBolsaAnterior() {
		return bolsaAnterior;
	}
	public void setBolsaAnterior(Set<BolsaObtidaAnteriormente> bolsaAnterior) {
		this.bolsaAnterior = bolsaAnterior;
	}
}
