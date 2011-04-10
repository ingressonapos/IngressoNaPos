package br.usp.ime.ingpos.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import br.usp.ime.ingpos.seguranca.Criptografia;

@Entity
public class RegistroNovoUsuario
    implements
        Serializable
{

    private static final long serialVersionUID = - 2224410851088369802L;

    @Id
    @GeneratedValue
    private Long registroNovoUsuarioID;

    @Column( unique = true )
    private String cpf;

    @Column( unique = true )
    private String email;

    @Column( unique = true )
    private String chaveAtivacao;

    @Column
    private String senha;

    @Transient
    private String confirmacaoSenha;

    @Column
    @Temporal( TemporalType.TIME )
    private Date dataHoraRegistro;

    public RegistroNovoUsuario()
    {
    }

    public Long getRegistroNovoUsuarioID()
    {
        return registroNovoUsuarioID;
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

    public String getChaveAtivacao()
    {
        return chaveAtivacao;
    }

    protected void setChaveAtivacao(
        String chaveAtivacao )
    {
        this.chaveAtivacao = chaveAtivacao;
    }

    public String getConfirmacaoSenha()
    {
        return confirmacaoSenha;
    }

    public void setConfirmacaoSenha(
        String confirmacaoSenha )
    {
        this.confirmacaoSenha = confirmacaoSenha;
    }

    public Date getDataHoraRegistro()
    {
        return dataHoraRegistro;
    }

    public void setDataHoraRegistro(
        Date dataHoraRegistro )
    {
        this.dataHoraRegistro = dataHoraRegistro;
    }

    public void setRegistroNovoUsuarioID(
        Long registroNovoUsuarioID )
    {
        this.registroNovoUsuarioID = registroNovoUsuarioID;
    }

    public void definirChaveAtivacao()
    {
        final StringBuilder builder = new StringBuilder();
        builder.append( registroNovoUsuarioID );
        builder.append( dataHoraRegistro.getTime() );
        setChaveAtivacao( Criptografia.md5( builder.toString() ) );
    }
}
