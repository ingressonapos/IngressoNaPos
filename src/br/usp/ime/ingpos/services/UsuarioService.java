package br.usp.ime.ingpos.services;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.usp.ime.ingpos.modelo.Usuario;
import br.usp.ime.ingpos.modelo.dao.UsuarioDao;
import br.usp.ime.ingpos.web.controllers.UsuarioSessao;

/**
 * Serviço que é responsavel por efetuar lógica de negocios para usuário. Possui
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

    public boolean autenticar(
        final String userName,
        final String password )
    {
        // TODO: Implementar encriptação de senha
        // a senha deve ser salva criptografada no banco de dados

        final Usuario usuario = usuarioDAO.findByLoginAndPassword( userName, password );

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
