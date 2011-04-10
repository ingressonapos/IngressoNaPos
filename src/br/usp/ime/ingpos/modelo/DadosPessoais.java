package br.usp.ime.ingpos.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

@Embeddable
public class DadosPessoais
    implements
        Serializable
{
    private static final long serialVersionUID = - 476234519172680388L;

    @Column( length = 50 )
    private String nomeCompleto;

    @Column
    private String email;

    @Column( length = 32 )
    private String senha;

    @Column( length = 11 )
    private String cpf;

    @Column
    private String nacionalidade;

    @Column
    private Date dataDeNascimento;

    @Column
    @Enumerated( EnumType.STRING )
    private TipoEstadoCivil estadoCivil;

    @Column
    private CedulaDeIdentidade cedulaDeIdentidade;

    @OneToOne
    private Endereco enderecoPermanente;

    @OneToOne
    private Endereco enderecoCorrespondencia;

    public String getNomeCompleto()
    {
        return nomeCompleto;
    }

    public void setNomeCompleto(
        String nomeCompleto )
    {
        this.nomeCompleto = nomeCompleto;
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

    public TipoEstadoCivil getEstadoCivil()
    {
        return estadoCivil;
    }

    public void setEstadoCivil(
        TipoEstadoCivil estadoCivil )
    {
        this.estadoCivil = estadoCivil;
    }

    public String getCpf()
    {
        return cpf;
    }

    public void setCpf(
        String cpf )
    {
        this.cpf = cpf;
    }

    public String getNacionalidade()
    {
        return nacionalidade;
    }

    public void setNacionalidade(
        String nacionalidade )
    {
        this.nacionalidade = nacionalidade;
    }

    public CedulaDeIdentidade getCedulaDeIdentidade()
    {
        return cedulaDeIdentidade;
    }

    public void setCedulaDeIdentidade(
        CedulaDeIdentidade cedulaDeIdentidade )
    {
        this.cedulaDeIdentidade = cedulaDeIdentidade;
    }

    public Date getDataDeNascimento()
    {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(
        Date dataDeNascimento )
    {
        this.dataDeNascimento = dataDeNascimento;
    }

    public Endereco getEnderecoPermanente()
    {
        return enderecoPermanente;
    }

    public void setEnderecoPermanente(
        Endereco enderecoPermanente )
    {
        this.enderecoPermanente = enderecoPermanente;
    }

    public Endereco getEnderecoCorrespondencia()
    {
        return enderecoCorrespondencia;
    }

    public void setEnderecoCorrespondencia(
        Endereco enderecoCorrespondencia )
    {
        this.enderecoCorrespondencia = enderecoCorrespondencia;
    }

    public static boolean isValidoCpf(
        final String cpf )
    {
        // TODO: Efetuar a validacao de CPF
        return false;
    }

}
