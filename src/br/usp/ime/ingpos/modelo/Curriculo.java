package br.usp.ime.ingpos.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Curriculo {

	@Id
	@GeneratedValue
	private Long curriculoID;
	@OneToOne
	private List<FormacaoAcademica> formacaoAcademica;
	@OneToOne
	private List<BolsaObtidaAnteriormente> bolsaAnterior;
	
	
	public Long getCurriculoID() {
		return curriculoID;
	}
	public void setCurriculoID(Long curriculoID) {
		this.curriculoID = curriculoID;
	}
	public List<FormacaoAcademica> getFormacaoAcademica() {
		return formacaoAcademica;
	}
	public void setFormacaoAcademica(List<FormacaoAcademica> formacaoAcademica) {
		this.formacaoAcademica = formacaoAcademica;
	}
	public List<BolsaObtidaAnteriormente> getBolsaAnterior() {
		return bolsaAnterior;
	}
	public void setBolsaAnterior(List<BolsaObtidaAnteriormente> bolsaAnterior) {
		this.bolsaAnterior = bolsaAnterior;
	}	
}
