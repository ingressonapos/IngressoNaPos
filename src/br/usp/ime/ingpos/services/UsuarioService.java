package br.usp.ime.ingpos.services;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.usp.ime.ingpos.modelo.Usuario;
import br.usp.ime.ingpos.modelo.dao.UsuarioDao;
import br.usp.ime.ingpos.seguranca.Criptografia;
import br.usp.ime.ingpos.web.controllers.UsuarioSessao;

/**
 * Servi�o que � responsavel por efetuar l�gica de negocios para usu�rio. Possui
 * o escopo de sessao
 */
@RequestScoped
@Component
public class UsuarioService
{
    private final UsuarioDao usuarioDAO;
    private final UsuarioSessao usuarioSessao;

    public UsuarioService(
        final UsuarioDao usuarioDAO,
        final UsuarioSessao usuarioSessao )
    {
        this.usuarioDAO = usuarioDAO;
        this.usuarioSessao = usuarioSessao;
    }

    public void salvar(
        Usuario usuario )
    {
        String senha = Criptografia.md5( usuario.getSenha() );

        // TODO: Implementar logica para salvar o usuario utilizando a senha
        // criptografada
    }

    public boolean autenticar(
        final String userName,
        String senha )
    {
        senha = Criptografia.md5( senha );

        final Usuario usuario = usuarioDAO.findByLoginAndPassword( userName, senha );

        final boolean success;
        if( usuario == null ) {
            success = false;
        } else {
            usuarioSessao.setUsuario( usuario );
            success = true;
        }
        return success;
    }

    public void deautenticate()
    {
        usuarioSessao.setUsuario( null );
    }

}
