package br.usp.ime.ingpos.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Embeddable
public class DadosPessoais
    implements
        Serializable
{
    private static final long serialVersionUID = - 476234519172680388L;

    @Column( length = 50 )
    private String nomeCompleto;

    @Column( length = 11, unique = true )
    private String cpf;

    @Column
    @Enumerated( EnumType.STRING )
    private TipoPais nacionalidade;

    @Column
    private Date dataDeNascimento;

    @Column
    @Enumerated( EnumType.STRING )
    private TipoEstadoCivil estadoCivil;

    @Column
    private CedulaDeIdentidade cedulaDeIdentidade;

    @OneToOne( cascade = {
        CascadeType.ALL
    }, fetch = FetchType.EAGER )
    private Endereco enderecoPermanente;

    @OneToOne( cascade = {
        CascadeType.ALL
    } )
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

    public TipoPais getNacionalidade()
    {
        return nacionalidade;
    }

    public void setNacionalidade(
        TipoPais nacionalidade )
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
        String cpf )
    {

        if( cpf == null )
            return false;

        cpf = cpf.replace( ".", "" ).replace( "-", "" );
        if( cpf.length() != 11 || cpf.equals( "00000000000" ) || cpf.equals( "11111111111" )
            || cpf.equals( "22222222222" ) || cpf.equals( "33333333333" )
            || cpf.equals( "44444444444" ) || cpf.equals( "55555555555" )
            || cpf.equals( "66666666666" ) || cpf.equals( "77777777777" )
            || cpf.equals( "88888888888" ) || cpf.equals( "99999999999" ) )
            return false;

        final String digito1 = cpf.substring( 9, 10 );
        final String digito2 = cpf.substring( 10, 11 );

        int i, j, somaDig1 = 0, somaDig2 = 0;

        for( i = 10, j = 0; i >= 2; i--, j++ )
            somaDig1 = somaDig1 + i * Integer.parseInt( cpf.substring( j, j + 1 ) );
        somaDig1 = somaDig1 % 11;

        if( somaDig1 < 2 )
            somaDig1 = 0;
        else
            somaDig1 = 11 - somaDig1;

        if( somaDig1 != Integer.parseInt( digito1 ) )
            return false;

        for( i = 11, j = 0; i >= 2; i--, j++ )
            somaDig2 = somaDig2 + i * Integer.parseInt( cpf.substring( j, j + 1 ) );
        somaDig2 = somaDig2 % 11;

        if( somaDig2 < 2 )
            somaDig2 = 0;
        else
            somaDig2 = 11 - somaDig2;

        if( somaDig2 != Integer.parseInt( digito2 ) )
            return false;

        return true;
    }

}
