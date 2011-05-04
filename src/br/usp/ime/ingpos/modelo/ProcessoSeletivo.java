package br.usp.ime.ingpos.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

// TODO: Implementar as assertivas
// 1. Somente um unico processo seletivo existe entre as datas
// dataDeAbertura e dataLimiteDeInscricao
//
// 2. Todas as datas importantes devem estar entre as datas dataDeAbertura e
// dataLimiteDeInscricao
//
// 3. dataDeAbertura deve ser menor que dataLimiteDeInscricao
@Entity
public class ProcessoSeletivo
{
    @Id
    @GeneratedValue
    private Long processoSeletivoId;

    @Column
    private String descricao;

    @Column
    @Temporal( TemporalType.TIMESTAMP )
    private Date dataDeAbertura;

    @Column
    @Temporal( TemporalType.TIMESTAMP )
    private Date dataLimiteDeInscricao;

    public ProcessoSeletivo()
    {
    }

    public Long getProcessoSeletivoId()
    {
        return processoSeletivoId;
    }

    protected void setProcessoSeletivoId(
        Long processoSeletivoId )
    {
        this.processoSeletivoId = processoSeletivoId;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(
        String descricao )
    {
        this.descricao = descricao;
    }

    public Date getDataDeAbertura()
    {
        return dataDeAbertura;
    }

    public void setDataDeAbertura(
        Date dataDeAbertura )
    {
        this.dataDeAbertura = dataDeAbertura;
    }

    public Date getDataLimiteDeInscricao()
    {
        return dataLimiteDeInscricao;
    }

    public void setDataLimiteDeInscricao(
        Date dataLimiteDeInscricao )
    {
        this.dataLimiteDeInscricao = dataLimiteDeInscricao;
    }

}
