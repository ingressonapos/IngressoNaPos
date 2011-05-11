package br.usp.ime.ingpos.modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Candidato implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private Long candidatoID;
    
    @OneToOne( cascade = CascadeType.ALL )
    private Curriculo curriculo;
    
    public Long getCandidatoID()
    {
        return candidatoID;
    }

    public void setCandidatoID(
        Long candidatoID )
    {
        this.candidatoID = candidatoID;
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
