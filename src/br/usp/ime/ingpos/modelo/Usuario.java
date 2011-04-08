package br.usp.ime.ingpos.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Usuario
    implements
        Serializable
{
    private static final long serialVersionUID = 5653550355165213879L;

    @Id
    @GeneratedValue
    private Long usuarioID;
    @Column( length = 50 )
    private String nome;
    @Column( length = 50 )
    private String login;
    @Column( length = 50 )
    private String senha;
    @ManyToOne
    Perfil perfil;
    @ManyToOne
    private Curriculo curriculo;
    @ManyToOne
    private DadosPessoais dadosPessoais;

    public Long getUsuarioID()
    {
        return usuarioID;
    }

    public void setUsuarioID(
        Long usuarioID )
    {
        this.usuarioID = usuarioID;
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

    public String getLogin()
    {
        return login;
    }

    public void setLogin(
        String login )
    {
        this.login = login;
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

	public Curriculo getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(Curriculo curriculo) {
		this.curriculo = curriculo;
	}

	public DadosPessoais getDadosPessoais() {
		return dadosPessoais;
	}

	public void setDadosPessoais(DadosPessoais dadosPessoais) {
		this.dadosPessoais = dadosPessoais;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
