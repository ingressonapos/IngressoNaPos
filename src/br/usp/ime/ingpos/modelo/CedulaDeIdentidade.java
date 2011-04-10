package br.usp.ime.ingpos.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class CedulaDeIdentidade
    implements
        Serializable
{

    private static final long serialVersionUID = - 7870494291067177168L;

    @Column( name = "identidade_numero" )
    private String numero;

    @Column( name = "identidade_digito" )
    private String digito;

    @Column( name = "identidade_tipo" )
    @Enumerated( EnumType.STRING )
    private TipoCedulaDeIdentidade tipo;

    public CedulaDeIdentidade()
    {
    }

    public String getNumero()
    {
        return numero;
    }

    public void setNumero(
        String numero )
    {
        this.numero = numero;
    }

    public String getDigito()
    {
        return digito;
    }

    public void setDigito(
        String digito )
    {
        this.digito = digito;
    }

    public TipoCedulaDeIdentidade getTipo()
    {
        return tipo;
    }

    public void setTipo(
        TipoCedulaDeIdentidade tipo )
    {
        this.tipo = tipo;
    }

}