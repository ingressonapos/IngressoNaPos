package br.usp.ime.ingpos.modelo;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Telefone
    implements
        Serializable
{
    private static final long serialVersionUID = - 7312070482560872606L;

    /**
     * Classe interna que representa um numero de telefone.
     */
    @Embeddable
    public static class NumeroTel
        implements
            Serializable
    {
        private static final long serialVersionUID = - 8637336971669125617L;

        private String codPais;
        private String codDDD;
        private String codTelefone;

        public NumeroTel()
        {
        }

        public String getCodPais()
        {
            return codPais;
        }

        public void setCodPais(
            String codPais )
        {
            this.codPais = codPais;
        }

        public String getCodDDD()
        {
            return codDDD;
        }

        public void setCodDDD(
            String codDDD )
        {
            this.codDDD = codDDD;
        }

        public String getCodTelefone()
        {
            return codTelefone;
        }

        public void setCodTelefone(
            String codTelefone )
        {
            this.codTelefone = codTelefone;
        }
    }

    @Embedded
    @AttributeOverrides( {
        @AttributeOverride( name = "codPais", column = @Column( name = "comercialCodPais" ) ),
        @AttributeOverride( name = "codDDD", column = @Column( name = "comercialcodDDD" ) ),
        @AttributeOverride( name = "codTelefone", column = @Column( name = "comercialCodTelefone" ) )
    } )
    private NumeroTel comercial;

    @Embedded
    @AttributeOverrides( {
        @AttributeOverride( name = "codPais", column = @Column( name = "residencialCodPais" ) ),
        @AttributeOverride( name = "codDDD", column = @Column( name = "residencialCodDDD" ) ),
        @AttributeOverride( name = "codTelefone", column = @Column( name = "residencialCodTelefone" ) )
    } )
    private NumeroTel residencial;

    @Embedded
    @AttributeOverrides( {
        @AttributeOverride( name = "codPais", column = @Column( name = "celularCodPais" ) ),
        @AttributeOverride( name = "codDDD", column = @Column( name = "celularcodDDD" ) ),
        @AttributeOverride( name = "codTelefone", column = @Column( name = "celularCodTelefone" ) )
    } )
    private NumeroTel celular;

    public Telefone()
    {
    }

    public NumeroTel getComercial()
    {
        return comercial;
    }

    public void setComercial(
        NumeroTel comercial )
    {
        this.comercial = comercial;
    }

    public NumeroTel getResidencial()
    {
        return residencial;
    }

    public void setResidencial(
        NumeroTel residencial )
    {
        this.residencial = residencial;
    }

    public NumeroTel getCelular()
    {
        return celular;
    }

    public void setCelular(
        NumeroTel celular )
    {
        this.celular = celular;
    }

}