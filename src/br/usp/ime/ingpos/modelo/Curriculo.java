package br.usp.ime.ingpos.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Curriculo
    implements
        Serializable
{

    private static final long serialVersionUID = 6231896863306406349L;

    @Id
    @GeneratedValue
    private Long curriculoID;

    @OneToMany
    @Cascade( {
        CascadeType.SAVE_UPDATE, CascadeType.DELETE
    } )
    @JoinColumn( name = "curriculoID" )
    private Set<FormacaoAcademica> formacoesAcademicas;

    @OneToMany
    @Cascade( {
        CascadeType.SAVE_UPDATE, CascadeType.DELETE
    } )
    @JoinColumn( referencedColumnName = "curriculoID" )
    private Set<Bolsa> bolsas;

    @OneToMany
    @JoinColumn( referencedColumnName = "curriculoID" )
    @Cascade( {
        CascadeType.SAVE_UPDATE, CascadeType.DELETE
    } )
    private Set<IniciacaoCientifica> iniciacoesCientificas;

    @OneToOne
    @Cascade( {
        CascadeType.SAVE_UPDATE, CascadeType.DELETE
    } )
    private PosComp posComp;

    public Curriculo()
    {
        this.formacoesAcademicas = new HashSet<FormacaoAcademica>();
        this.bolsas = new HashSet<Bolsa>();
        this.iniciacoesCientificas = new HashSet<IniciacaoCientifica>();
    }

    public Set<IniciacaoCientifica> getIniciacoesCientificas()
    {
        return iniciacoesCientificas;
    }

    public void setIniciacoesCientificas(
        Set<IniciacaoCientifica> iniciacaoCientifica )
    {
        this.iniciacoesCientificas = iniciacaoCientifica;
    }

    public PosComp getPosComp()
    {
        return posComp;
    }

    public void setPosComp(
        PosComp posComp )
    {
        this.posComp = posComp;
    }

    public Long getCurriculoID()
    {
        return curriculoID;
    }

    public void setCurriculoID(
        Long curriculoID )
    {
        this.curriculoID = curriculoID;
    }

    public Set<FormacaoAcademica> getFormacoesAcademicas()
    {
        return formacoesAcademicas;
    }

    protected void setFormacoesAcademicas(
        Set<FormacaoAcademica> formacaoAcademica )
    {
        this.formacoesAcademicas = formacaoAcademica;
    }

    public Set<Bolsa> getBolsas()
    {
        return bolsas;
    }

    public void setBolsas(
        Set<Bolsa> bolsas )
    {
        this.bolsas = bolsas;
    }

    /**
     * Adiciona uma formação academica ao curriculo. Se ja existe uma formação
     * academica igual à informada, substitui a mesma no conjunto.
     * 
     * @param formacaoAcademica
     */
    public void adicionaFormacaoAcademica(
        FormacaoAcademica formacaoAcademica )
    {
        this.formacoesAcademicas.remove( formacaoAcademica );
        this.formacoesAcademicas.add( formacaoAcademica );
    }

    public void removeFormacaoAcademica(
        FormacaoAcademica formacaoAcademica )
    {
        this.formacoesAcademicas.remove( formacaoAcademica );
    }

    public void adicionaIniciacaoCientifica(
        IniciacaoCientifica iniciacaoCientifica )
    {
        this.iniciacoesCientificas.add( iniciacaoCientifica );

    }

}
