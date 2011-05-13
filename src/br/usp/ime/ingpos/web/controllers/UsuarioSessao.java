package br.usp.ime.ingpos.web.controllers;

import java.io.Serializable;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.usp.ime.ingpos.modelo.Usuario;

@SessionScoped
@Component
public class UsuarioSessao
    implements
        Serializable
{

    private static final long serialVersionUID = 7238350398131148312L;

    private Usuario usuario;

    public Long getUsuarioId()
    {
        return usuario.getUsuarioID();
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

    public String getNome()
    {
        return usuario.getDadosPessoais().getNomeCompleto();
    }

    public boolean isUsuarioAutenticado()
    {
        return ( usuario != null && usuario.isAtivo() );
    }

}
