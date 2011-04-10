package br.usp.ime.ingpos.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
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
    private String logadouro;

    @Column
    private String numero;

    @Column
    private String complemento;

    @Column
    private String pais;

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
    }

    public Long getEnderecoID()
    {
        return enderecoID;
    }

    public String getLogadouro()
    {
        return logadouro;
    }

    public void setLogadouro(
        String logadouro )
    {
        this.logadouro = logadouro;
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

    public String getPais()
    {
        return pais;
    }

    public void setPais(
        String pais )
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
