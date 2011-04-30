package br.usp.ime.ingpos.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CartaDeRecomendacao
{
    @Id
    @GeneratedValue
    private Long cartaDeRecomendacaoID;

    @Column( length = 50, nullable = false )
    private String email;

    @Column( length = 100, nullable = false )
    private String nome;

    @Column( length = 50, unique = true, nullable = false )
    private String hash;

    @Column
    @Temporal( TemporalType.DATE )
    private Date dataDeEnvio;

    @ManyToOne
    private Usuario usuario;

    public Long getCartaDeRecomendacaoID()
    {
        return cartaDeRecomendacaoID;
    }

    public void setCartaDeRecomendacaoID(
        Long cartaDeRecomendacaoID )
    {
        this.cartaDeRecomendacaoID = cartaDeRecomendacaoID;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(
        String mail )
    {
        this.email = mail;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(
        String nome )
    {
        this.nome = nome;
    }

    public String getHash()
    {
        return hash;
    }

    public void setHash(
        String hash )
    {
        this.hash = hash;
    }

    public Date getDataDeEnvio()
    {
        return dataDeEnvio;
    }

    public void setDataDeEnvio(
        final Date dataDeEnvio )
    {
        this.dataDeEnvio = dataDeEnvio;
    }

    public Usuario getUsuario()
    {
        return usuario;
    }

    public void setUsuario(
        Usuario usuario )
    {
        this.usuario = usuario;
    }

}
