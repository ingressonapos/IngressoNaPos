package br.usp.ime.ingpos.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity

public class Curriculo {

	@Id
	@GeneratedValue
	private Long curriculoID;
	private FormacaoAcademica formacaoAcad;
	private BolsaObtidaAnteriormente bolsaAnt;
	
	
	public Long getCurriculoID() {
		return curriculoID;
	}
	public void setCurriculoID(Long curriculoID) {
		this.curriculoID = curriculoID;
	}
	public FormacaoAcademica getFormacaoAcad() {
		return formacaoAcad;
	}
	public void setFormacaoAcad(FormacaoAcademica formacaoAcad) {
		this.formacaoAcad = formacaoAcad;
	}
	public BolsaObtidaAnteriormente getBolsaAnt() {
		return bolsaAnt;
	}
	public void setBolsaAnt(BolsaObtidaAnteriormente bolsaAnt) {
		this.bolsaAnt = bolsaAnt;
	}
	
}
