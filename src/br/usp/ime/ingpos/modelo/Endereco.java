package br.usp.ime.ingpos.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Endereco
    implements
        Serializable
{
    private static final long serialVersionUID = 5653550355165213879L;

    @Id
    @GeneratedValue
    private Long enderecoID;

    @Column
    private String logradouro;

    @Column
    private String numero;

    @Column
    private String complemento;

    @Column
    @Enumerated( EnumType.STRING )
    private TipoPais pais;

    @Column
    private String estado;

    @Column
    private String cidade;

    @Embedded
    private CEP cep;

    @Embedded
    private Telefone telefone;

    public Endereco()
    {
    	telefone = new Telefone();
    	cep = new CEP();
    }

    public Long getEnderecoID()
    {
        return enderecoID;
    }

    public String getLogradouro()
    {
        return logradouro;
    }

    public void setLogradouro(
        String logradouro )
    {
        this.logradouro = logradouro;
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

    public String getComplemento()
    {
        return complemento;
    }

    public void setComplemento(
        String complemento )
    {
        this.complemento = complemento;
    }

    public String getCidade()
    {
        return cidade;
    }

    public void setCidade(
        String cidade )
    {
        this.cidade = cidade;
    }

    public String getEstado()
    {
        return estado;
    }

    public void setEstado(
        String estado )
    {
        this.estado = estado;
    }

    public TipoPais getPais()
    {
        return pais;
    }

    public void setPais(
        TipoPais pais )
    {
        this.pais = pais;
    }

    public CEP getCep()
    {
        return cep;
    }

    public void setCep(
        CEP cep )
    {
        this.cep = cep;
    }

    public Telefone getTelefone()
    {
        return telefone;
    }

    public void setTelefone(
        Telefone telefone )
    {
        this.telefone = telefone;
    }

}
