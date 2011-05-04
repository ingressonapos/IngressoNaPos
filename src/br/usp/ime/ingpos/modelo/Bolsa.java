package br.usp.ime.ingpos.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Bolsa
    implements
        Serializable
{

    private static final long serialVersionUID = - 7231171812688553305L;

    @Id
    @GeneratedValue
    private Long bolsaId;

    @Column( length = 50 )
    private String tipoBolsa;

    @Column( length = 50 )
    private String nomeInstituicao; // Instituicao que concedeu a bolsa

    @Temporal( TemporalType.DATE )
    private Date ingressoData;

    @Temporal( TemporalType.DATE )
    private Date terminoData;

	@Column( length = 50 )
    private String nomeOrientador;

    @Column( length = 50 )
    private String nomeProjeto;

    @ManyToOne
    @JoinColumn( name = "curriculoID" )
    private Curriculo curriculo;

    public Bolsa()
    {
    }

    public Long getBolsaId()
    {
        return bolsaId;
    }
    
    public Date getIngressoData() {
		return ingressoData;
	}

	public void setIngressoData(Date ingressoData) {
		this.ingressoData = ingressoData;
	}

	public Date getTerminoData() {
		return terminoData;
	}

	public void setTerminoData(Date terminoData) {
		this.terminoData = terminoData;
	}

    public String getTipoBolsa()
    {
        return tipoBolsa;
    }

    public void setTipoBolsa(
        String tipoBolsa )
    {
        this.tipoBolsa = tipoBolsa;
    }

    public String getNomeInstituicao()
    {
        return nomeInstituicao;
    }

    public void setNomeInstituicao(
        String nomeInstituicao )
    {
        this.nomeInstituicao = nomeInstituicao;
    }

    public String getNomeOrientador()
    {
        return nomeOrientador;
    }

    public void setNomeOrientador(
        String nomeOrientador )
    {
        this.nomeOrientador = nomeOrientador;
    }

    public String getNomeProjeto()
    {
        return nomeProjeto;
    }

    public void setNomeProjeto(
        String nomeProjeto )
    {
        this.nomeProjeto = nomeProjeto;
    }

    public Curriculo getCurriculo()
    {
        return curriculo;
    }

    public void setCurriculo(
        Curriculo curriculo )
    {
        this.curriculo = curriculo;
    }
}
