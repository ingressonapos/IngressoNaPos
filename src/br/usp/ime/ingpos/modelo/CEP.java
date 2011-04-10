package br.usp.ime.ingpos.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CEP
    implements
        Serializable
{
    private static final long serialVersionUID = 5653550355165213879L;

    @Column( length = 5 )
    private String regiao;

    @Column( length = 3 )
    private String sufixo;

    public CEP()
    {
    }

    public String getRegiao()
    {
        return regiao;
    }

    public void setRegiao(
        String regiao )
    {
        this.regiao = regiao;
    }

    public String getSufixo()
    {
        return sufixo;
    }

    public void setSufixo(
        String sufixo )
    {
        this.sufixo = sufixo;
    }
}
