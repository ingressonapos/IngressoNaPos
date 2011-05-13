package br.usp.ime.ingpos.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AreaDeInteresse {
    @Id
    @GeneratedValue
    private Long areaDeInteresseID;
	
	private String descricao;
	private boolean selecionada;
	
	public Long getAreaDeInteresseID() {
		return areaDeInteresseID;
	}

	public void setAreaDeInteresseID(Long areaDeInteresseID) {
		this.areaDeInteresseID = areaDeInteresseID;
	}

	public AreaDeInteresse(String descricao, boolean selecionada)
	{
		this.descricao = descricao;
		this.selecionada = selecionada;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isSelecionada() {
		return selecionada;
	}
	public void setSelecionada(boolean selecionada) {
		this.selecionada = selecionada;
	}
}