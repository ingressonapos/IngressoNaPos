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
public class FormacaoAcademica
    implements
        Serializable
{

    private static final long serialVersionUID = 5838966089146951802L;

    @Id
    @GeneratedValue
    private Long formacaoAcademicaId;

    @Column( length = 50 )
    private String Instituicao;

    @Temporal( TemporalType.DATE )
    private Date ingressoData;

    @Temporal( TemporalType.DATE )
    private Date terminoData;

    @Column
    private String Titulo;

    @Column( length = 50 )
    private String nomeOrientador;

    @Column( length = 50 )
    private String tituloDissert;

    @ManyToOne
    @JoinColumn( name = "curriculoID" )
    private Curriculo curriculo;

    public FormacaoAcademica()
    {
    }

    public Long getFormacaoAcademicaId()
    {
        return formacaoAcademicaId;
    }

    public String getInstituicao()
    {
        return Instituicao;
    }

    public void setInstituicao(
        String instituicao )
    {
        Instituicao = instituicao;
    }

    public Date getIngressoData()
    {
        return ingressoData;
    }

    public void setIngressoData(
        Date ingressoData )
    {
        this.ingressoData = ingressoData;
    }

    public Date getTerminoData()
    {
        return terminoData;
    }

    public void setTerminoData(
        Date terminoData )
    {
        this.terminoData = terminoData;
    }

    public String getTitulo()
    {
        return Titulo;
    }

    public void setTitulo(
        String titulo )
    {
        Titulo = titulo;
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

    public String getTituloDissert()
    {
        return tituloDissert;
    }

    public void setTituloDissert(
        String tituloDissert )
    {
        this.tituloDissert = tituloDissert;
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
