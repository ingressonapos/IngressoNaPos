package br.usp.ime.ingpos.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Usuario
    implements
        Serializable
{
    private static final long serialVersionUID = 5653550355165213879L;

    @Id
    @GeneratedValue
    private Long usuarioID;

    @Column( unique = true )
    private String email;

    @Column( length = 32 )
    private String senha;

    @Embedded
    private DadosPessoais dadosPessoais;

    @Column( columnDefinition = "BOOLEAN" )
    private boolean ativo;

    @ManyToOne( optional = false )
    private Perfil perfil;

    @OneToOne
    private Candidato candidato;

    public Usuario()
    {
        this.dadosPessoais = new DadosPessoais();
    }

    public Long getUsuarioID()
    {
        return usuarioID;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(
        String email )
    {
        this.email = email;
    }

    public String getSenha()
    {
        return senha;
    }

    public void setSenha(
        String senha )
    {
        this.senha = senha;
    }

    public Perfil getPerfil()
    {
        return perfil;
    }

    public void setPerfil(
        Perfil perfil )
    {
        this.perfil = perfil;
    }

    public DadosPessoais getDadosPessoais()
    {
        return dadosPessoais;
    }

    public void setDadosPessoais(
        DadosPessoais dadosPessoais )
    {
        this.dadosPessoais = dadosPessoais;
    }

    public void setAtivo(
        boolean ativo )
    {
        this.ativo = ativo;
    }

    public boolean isAtivo()
    {
        return ativo;
    }

    public Candidato getCandidato()
    {
        return candidato;
    }

    public void setCandidato(
        Candidato candidato )
    {
        this.candidato = candidato;
    }

}
