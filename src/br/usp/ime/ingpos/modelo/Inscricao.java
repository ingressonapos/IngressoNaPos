package br.usp.ime.ingpos.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Inscricao implements Serializable{
	private static final long serialVersionUID = 2908521459850511243L;
	
    @Id
    @GeneratedValue
    private Long inscricaoID;
	
    @ManyToOne
	private ProcessoSeletivo processoSeletivo;
	
	private String outrosProcessosSeletivos;
	
	private String orientadorDesejado;
	
	private String dedicacaoExclusiva;
	
    @ManyToMany
    @JoinColumn( referencedColumnName = "inscricaoID" )
    @Cascade( {
        CascadeType.SAVE_UPDATE, CascadeType.DELETE
    } )
	private List<AreaDeInteresse> areasDeInteresseMaiorAfinidade;
	
    @ManyToMany
    @JoinColumn( referencedColumnName = "inscricaoID" )
    @Cascade( {
        CascadeType.SAVE_UPDATE, CascadeType.DELETE
    } )
	private List<AreaDeInteresse> areasDeInteresseMenorAfinidade;

	public Long getInscricaoID() {
		return inscricaoID;
	}

	public void setInscricaoID(Long inscricaoID) {
		this.inscricaoID = inscricaoID;
	}

	public ProcessoSeletivo getProcessoSeletivo() {
		return processoSeletivo;
	}

	public void setProcessoSeletivo(ProcessoSeletivo processoSeletivo) {
		this.processoSeletivo = processoSeletivo;
	}

	public String getOutrosProcessosSeletivos() {
		return outrosProcessosSeletivos;
	}

	public void setOutrosProcessosSeletivos(String outrosProcessosSeletivos) {
		this.outrosProcessosSeletivos = outrosProcessosSeletivos;
	}

	public String getOrientadorDesejado() {
		return orientadorDesejado;
	}

	public void setOrientadorDesejado(String orientadorDesejado) {
		this.orientadorDesejado = orientadorDesejado;
	}

	public String getDedicacaoExclusiva() {
		return dedicacaoExclusiva;
	}

	public void setDedicacaoExclusiva(String dedicacaoExclusiva) {
		this.dedicacaoExclusiva = dedicacaoExclusiva;
	}

	public List<AreaDeInteresse> getAreasDeInteresseMaiorAfinidade() {
		return areasDeInteresseMaiorAfinidade;
	}

	public void setAreasDeInteresseMaiorAfinidade(
			List<AreaDeInteresse> areasDeInteresseMaiorAfinidade) {
		this.areasDeInteresseMaiorAfinidade = areasDeInteresseMaiorAfinidade;
	}

	public List<AreaDeInteresse> getAreasDeInteresseMenorAfinidade() {
		return areasDeInteresseMenorAfinidade;
	}

	public void setAreasDeInteresseMenorAfinidade(
			List<AreaDeInteresse> areasDeInteresseMenorAfinidade) {
		this.areasDeInteresseMenorAfinidade = areasDeInteresseMenorAfinidade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
