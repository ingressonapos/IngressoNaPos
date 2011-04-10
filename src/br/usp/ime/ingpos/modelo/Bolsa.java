package br.usp.ime.ingpos.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Bolsa
{
    @Id
    @GeneratedValue
    private Long bolsaId;

    @Column( length = 50 )
    private String tipoBolsa;

    @Column( length = 50 )
    private String nomeInstituicao; // Instituicao que concedeu a bolsa

    @Column
    private Integer duracao;

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

    public Integer getDuracao()
    {
        return duracao;
    }

    public void setDuracao(
        Integer duracao )
    {
        this.duracao = duracao;
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
