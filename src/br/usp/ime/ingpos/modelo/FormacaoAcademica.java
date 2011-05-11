package br.usp.ime.ingpos.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

    @Column
    @Enumerated( EnumType.STRING )
    private TipoDeFormacao tipoDeFormacao;

    @Column( length = 50 )
    private String instituicao;

    @Temporal( TemporalType.TIMESTAMP )
    private Date ingressoData;

    @Temporal( TemporalType.TIMESTAMP )
    private Date terminoData;

    @Column
    private String titulo;

    @Column( length = 50 )
    private String nomeOrientador;

    @Column( length = 50 )
    private String tituloDissert;

    public FormacaoAcademica()
    {
    }

    public void setFormacaoAcademicaId(
        Long formacaoAcademicaId )
    {
        this.formacaoAcademicaId = formacaoAcademicaId;
    }

    public Long getFormacaoAcademicaId()
    {
        return formacaoAcademicaId;
    }

    public String getInstituicao()
    {
        return instituicao;
    }

    public void setInstituicao(
        String instituicao )
    {
        this.instituicao = instituicao;
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
        return titulo;
    }

    public void setTitulo(
        String titulo )
    {
        this.titulo = titulo;
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

    public void setTipoDeFormacao(
        TipoDeFormacao tipoDeFormacao )
    {
        this.tipoDeFormacao = tipoDeFormacao;
    }

    public TipoDeFormacao getTipoDeFormacao()
    {
        return tipoDeFormacao;
    }

    @Override
    public boolean equals(
        Object obj )
    {
        if( this == obj ) {
            return true;
        }
        if( ! obj.getClass().equals( this.getClass() ) ) {
            return false;
        }

        FormacaoAcademica formacaoAcademica = (FormacaoAcademica) obj;

        if( formacaoAcademicaId != null ) {
            return formacaoAcademicaId.equals( formacaoAcademica.getFormacaoAcademicaId() );
        } else {
            return super.equals( obj );
        }
    }

    @Override
    public int hashCode()
    {
        if( formacaoAcademicaId != null ) {
            return formacaoAcademicaId.hashCode();
        } else {
            return super.hashCode();
        }
    }
}
