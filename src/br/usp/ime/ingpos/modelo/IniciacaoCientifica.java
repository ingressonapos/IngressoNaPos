package br.usp.ime.ingpos.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class IniciacaoCientifica
    implements
        Serializable
{
    private static final long serialVersionUID = - 5997534572428941794L;

    @Id
    @GeneratedValue
    private Long iniciacaoCientificaId;

    @Column( length = 50 )
    private String nomeOrientador;

    @Column( length = 50 )
    private String nomeInstituicao;

    @Column( length = 50 )
    private String temaProjeto;

    @ManyToOne
    @JoinColumn( name = "curriculoID" )
    private Curriculo curriculo;

    public IniciacaoCientifica()
    {
    }

    public Long getIniciacaoCientificaId()
    {
        return iniciacaoCientificaId;
    }

    public void setIniciacaoCientificaId(
        Long iniciacaoCientificaId )
    {
        this.iniciacaoCientificaId = iniciacaoCientificaId;
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

    public String getNomeInstituicao()
    {
        return nomeInstituicao;
    }

    public void setNomeInstituicao(
        String nomeInstituicao )
    {
        this.nomeInstituicao = nomeInstituicao;
    }

    public String getTemaProjeto()
    {
        return temaProjeto;
    }

    public void setTemaProjeto(
        String temaProjeto )
    {
        this.temaProjeto = temaProjeto;
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
