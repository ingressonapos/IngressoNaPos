package br.usp.ime.ingpos.modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToMany;

@Embeddable
public class DadosPessoais
{
    @Column( length = 50 )
    private String nomeCompleto;

    @Column
    private String email;

    @Column
    private String senha;

    @Column
    private String estadoCivil;

    @Column( length = 11 )
    private String cpf;

    @Column
    private String nacionalidade;

    @Column
    private CedulaDeIdentidade cedulaDeIdentidade;

    @ManyToMany
    private List<Endereco> endereco;

    @Column
    private Date dataDeNascimento;

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

    public String getEstadoCivil()
    {
        return estadoCivil;
    }

    public void setEstadoCivil(
        String estadoCivil )
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

    public List<Endereco> getEndereco()
    {
        return endereco;
    }

    public void setEndereco(
        List<Endereco> endereco )
    {
        this.endereco = endereco;
    }
}
