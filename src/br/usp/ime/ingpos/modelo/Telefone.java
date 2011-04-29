package br.usp.ime.ingpos.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Telefone
    implements
        Serializable
{
    private static final long serialVersionUID = - 7312070482560872606L;          

    @Column( length = 3 )
    private String codPais;
    
    @Column( length = 3 )
    private String codDDD;
    
    @Column( length = 10 )
    private String codTelefone;

    public Telefone()
    {
    }

    public String getCodPais()
    {
        return codPais;
    }

    public void setCodPais( String codPais )
    {
        this.codPais = codPais;
    }

    public String getCodDDD()
    {
        return codDDD;
    }

    public void setCodDDD( String codDDD )
    {
        this.codDDD = codDDD;
    }

    public String getCodTelefone()
    {
        return codTelefone;
    }

    public void setCodTelefone( String codTelefone )
    {
        this.codTelefone = codTelefone;
    }
}