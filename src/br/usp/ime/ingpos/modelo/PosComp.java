package br.usp.ime.ingpos.modelo;

import java.io.File;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class PosComp {
	@Id
	@GeneratedValue
	private Long posCompId;
	private Integer notaMatematica;
	private Integer notaLogica;
	private Integer notaTecnologia;
	private String arquivoPosComp;
	
	public Long getPosCompId() {
		return posCompId;
	}
	public void setPosCompId(Long posCompId) {
		this.posCompId = posCompId;
	}
	public Integer getNotaMatematica() {
		return notaMatematica;
	}
	public void setNotaMatematica(Integer notaMatematica) {
		this.notaMatematica = notaMatematica;
	}
	public Integer getNotaLogica() {
		return notaLogica;
	}
	public void setNotaLogica(Integer notaLogica) {
		this.notaLogica = notaLogica;
	}
	public Integer getNotaTecnologia() {
		return notaTecnologia;
	}
	public void setNotaTecnologia(Integer notaTecnologia) {
		this.notaTecnologia = notaTecnologia;
	}
	public String getArquivoPosComp() {
		return arquivoPosComp;
	}
	public void setArquivoPosComp(String arquivoPosComp) {
		this.arquivoPosComp = arquivoPosComp;
	}

}
